package net.dynamichorizons.rp.print;

import java.awt.print.PrinterJob;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import net.dynamichorizons.rp.domain.order.Order;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.xml.XmlMapper;

public class OrderPrintProcessor
{
    private static final Logger LOG = LoggerFactory.getLogger( OrderPrintProcessor.class );

    private static final String CONFIG_FILE = "rp-order-printer.properties";

    private static final String PRINTER_NAME = "client.printer.name";

    private final static String XSLT_FILE = "/order-transform.xsl";

    private final FopFactory fopFactory = FopFactory.newInstance();

    private final XmlMapper xmlMapper = new XmlMapper();

    private final InputStream orderXsltFile;

    private FOUserAgent foUserAgent;

    private Transformer transformer;

    private Configuration config;

    public OrderPrintProcessor()
        throws Exception
    {
        try
        {
            orderXsltFile = OrderPrintProcessor.class.getResourceAsStream( XSLT_FILE );
        }
        catch ( Exception e )
        {
            LOG.error( "Could Not Find XSLT File", e );
            throw new Exception( "Could Not Find XSLT File", e );
        }

        config = new PropertiesConfiguration( CONFIG_FILE );

        initialize();
    }

    public void printOrder( Order order )
        throws Exception
    {
        LOG.info( "PRINTING ORDER: " + order.getId() );

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try
        {
            createPdf( order, outputStream );
        }
        catch ( Exception e )
        {
            LOG.error( "Could Not Create PDF From Order", e );

            // We didn't get the data
            throw e;
        }

        byte[] pdfBytes = outputStream.toByteArray();

        try
        {
            printOrder( order, PDDocument.load( new ByteArrayInputStream( pdfBytes ) ) );
        }
        catch ( Exception e )
        {
            LOG.error( "Could Not Print Order", e );

            throw e;
        }
    }

    private void createPdf( Order order, OutputStream outputStream )
        throws Exception
    {

        outputStream = new BufferedOutputStream( outputStream );

        try
        {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop( MimeConstants.MIME_PDF, foUserAgent, outputStream );

            // Create Xml Byte Output
            byte[] xmlBytes = xmlMapper.writeValueAsBytes( order );

            // Setup input for XSLT transformation
            Source source = new StreamSource( new ByteArrayInputStream( xmlBytes ) );

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult( fop.getDefaultHandler() );

            // Start XSLT transformation and FOP processing
            transformer.transform( source, res );
        }
        catch ( Exception e )
        {
            LOG.error( "Could Not Create PDF", e );
            throw new Exception( "Could Not Create PDF", e );
        }
        finally
        {
            try
            {
                outputStream.close();
            }
            catch ( IOException e )
            {
                LOG.warn( "Could Not Close PDF Stream", e );
            }
        }
    }

    private void printOrder( Order order, PDDocument orderPdf )
        throws Exception
    {
        PrintService[] services = PrintServiceLookup.lookupPrintServices( null, null );
        if ( services.length == 0 )
        {
            throw new Exception( "No result" );
        }

        PrintService sps = null;
        for ( PrintService service : services )
        {
            if ( service.getName().indexOf( config.getString( PRINTER_NAME ) ) >= 0 )
            {
                sps = service;
            }
        }

        LOG.debug( "PRINTING ORDER " + order.getId() + " ON PRINTER " + sps.getName() );
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setJobName( "Order: " + order.getId() );
        printJob.setPrintService( sps );

        orderPdf.silentPrint( printJob );
    }

    private void initialize()
        throws TransformerConfigurationException
    {
        // Initialize FOP
        LOG.debug( "INITALIZE FOP USER AGENT" );
        foUserAgent = fopFactory.newFOUserAgent();

        // Setup XSLT
        LOG.debug( "SETUP XSLT TRANSFORMER" );
        TransformerFactory factory = TransformerFactory.newInstance();
        transformer = factory.newTransformer( new StreamSource( orderXsltFile ) );
    }

}
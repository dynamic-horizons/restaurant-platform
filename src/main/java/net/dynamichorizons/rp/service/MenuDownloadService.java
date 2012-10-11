/**
 * Copyright (C) 2012 Dynamic Horizons, LLC <https://www.dynamichorizons.net>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 *   
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package net.dynamichorizons.rp.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import net.dynamichorizons.rp.domain.menu.Menu;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDownloadService
{

    private final static Logger logger = LoggerFactory.getLogger( MenuDownloadService.class );

    private final static String XSLT_FILE = "/menu-transform.xsl";

    private final FopFactory fopFactory = FopFactory.newInstance();

    private final JAXBContext context = JAXBContext.newInstance( Menu.class );

    private final File menuXsltFile;

    @Autowired
    private MenuService menuService;

    public MenuDownloadService()
        throws Exception
    {
        try
        {
            menuXsltFile = new File( this.getClass().getResource( XSLT_FILE ).toURI() );
        }
        catch ( URISyntaxException e )
        {
            logger.error( "Could Not Find XSLT File", e );
            throw new Exception( "Could Not Find XSLT File", e );
        }
    }

    public void generateMenu( Menu menu, OutputStream outputStream )
        throws Exception
    {

        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        outputStream = new java.io.BufferedOutputStream( outputStream );

        try
        {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop( MimeConstants.MIME_PDF, foUserAgent, outputStream );

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer( new StreamSource( menuXsltFile ) );

            // Setup input for XSLT transformation
            Source source = new JAXBSource( context, menu );

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult( fop.getDefaultHandler() );

            // Start XSLT transformation and FOP processing
            transformer.transform( source, res );
        }
        catch ( Exception e )
        {
            logger.error( "Could Not Create PDF", e );
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
                logger.warn( "Could Not Close PDF Stream", e );
            }
        }
    }
}

import java.io.ByteArrayInputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class Test
{
    public static void main( String[] argv )
    {

        try
        {
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();

            DocPrintJob job = printService.createPrintJob();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append( "ORDER TEST" );
            stringBuilder.append( "ORDER TEST" );

            ByteArrayInputStream inputStream = new ByteArrayInputStream( stringBuilder.toString().getBytes() );

            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc mydoc = new SimpleDoc( inputStream, flavor, null );

            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();

            job.print( mydoc, printRequestAttributeSet );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
}

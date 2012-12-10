package net.dynamichorizons.rp.print;

import java.util.Scanner;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderPrinterDaemon
    implements Daemon
{

    private static final Logger LOG = LoggerFactory.getLogger( OrderPrinterDaemon.class );

    private static OrderPrinterDaemon SERVICE = null;

    public static OrderPrinterDaemon getInstance()
        throws Exception
    {
        if ( SERVICE == null )
        {
            SERVICE = new OrderPrinterDaemon();
        }

        return SERVICE;
    }

    private OrderPrinterEngine orderPrinterEngine;

    public OrderPrinterDaemon()
        throws Exception
    {
        this.orderPrinterEngine = new OrderPrinterEngine();
    }

    public void windowsStart()
    {
        LOG.debug( "windowsStart called" );
        try
        {
            initialize();
        }
        catch ( Exception e )
        {
            LOG.error( "Could Not Initialize and Start Daemon", e );
        }
    }

    public void windowsStop()
    {
        LOG.debug( "windowsStop called" );
        terminate();
    }

    // Implementing the Daemon interface is not required for Windows but is for Linux
    @Override
    public void init( DaemonContext arg0 )
        throws Exception
    {
        LOG.debug( "Daemon init" );
    }

    @Override
    public void start()
    {
        LOG.debug( "Daemon start" );
        try
        {
            initialize();
        }
        catch ( Exception e )
        {
            LOG.error( "Error Running The Service", e );
        }
        finally
        {
            terminate();
        }
    }

    @Override
    public void stop()
    {
        LOG.debug( "Daemon stop" );
        terminate();
    }

    @Override
    public void destroy()
    {
        LOG.debug( "Daemon destroy" );
    }

    /**
     * Do the work of starting the engine
     * 
     * @throws Exception
     */
    private void initialize()
        throws Exception
    {
        orderPrinterEngine.start();
    }

    /**
     * Cleanly stop the engine.
     */
    public void terminate()
    {
        if ( orderPrinterEngine != null )
        {
            LOG.info( "Stopping the Engine" );
            orderPrinterEngine.stopExecution();
            LOG.info( "Engine stopped" );
        }

        orderPrinterEngine = null;
    }

    /**
     * The Java entry point.
     * 
     * @param args Command line arguments, all ignored.
     */
    public static void main( String[] args )
    {
        // the main routine is only here so I can also run the app from the command line
        try
        {
            getInstance().initialize();
        }
        catch ( Exception e )
        {
            LOG.error( "Coud Not Initialize The Service", e );

            return;
        }

        Scanner sc = new Scanner( System.in );
        while ( !sc.nextLine().contains( "stop" ) )
        {
            ;
        }
        sc.close();

        try
        {
            getInstance().terminate();
        }
        catch ( Exception e )
        {
            LOG.error( "Coud Not Terminate The Service", e );

            return;
        }
    }

    /**
     * Static methods called by prunsrv to start/stop the Windows service. Pass the argument "start" to start the
     * service, and pass "stop" to stop the service. Taken lock, stock and barrel from Christopher Pierce's bLOG at
     * http://blog.platinumsolutions.com/node/234
     * 
     * @param args Arguments from prunsrv command line
     * @throws Exception
     **/
    public static void windowsService( String args[] )
    {
        String cmd = "start";
        if ( args.length > 0 )
        {
            cmd = args[0];
        }

        if ( "start".equals( cmd ) )
        {
            try
            {
                getInstance().windowsStart();
            }
            catch ( Exception e )
            {
                LOG.error( "COULD NOT START", e );

                throw new RuntimeException( e );
            }
        }
        else
        {
            try
            {
                getInstance().windowsStop();
            }
            catch ( Exception e )
            {
                LOG.error( "COULD NOT STOP", e );

                throw new RuntimeException( e );
            }
        }
    }
}

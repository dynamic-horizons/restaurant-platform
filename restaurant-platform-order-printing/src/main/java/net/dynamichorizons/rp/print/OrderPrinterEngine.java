package net.dynamichorizons.rp.print;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderPrinterEngine
    extends Thread
{
    private static final Logger LOG = LoggerFactory.getLogger( OrderPrinterEngine.class );

    // 30 Seconds
    private static final int WAIT_TIME = 30;

    private OrderPrintExecutor orderPrintExecutor;

    private OrderPrinterRemoteClient orderPrinterRemoteClient;

    private OrderPrintProcessor orderPrintProcessor;

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool( 1 );

    private ScheduledFuture<?> serviceHandle = null;

    public OrderPrinterEngine()
        throws Exception
    {
        orderPrintProcessor = new OrderPrintProcessor();
        orderPrinterRemoteClient = new OrderPrinterRemoteClient();
        orderPrintExecutor = new OrderPrintExecutor( orderPrintProcessor, orderPrinterRemoteClient );
    }

    @Override
    public void run()
    {
        serviceHandle = scheduler.scheduleAtFixedRate( orderPrintExecutor, 0, WAIT_TIME, SECONDS );
        try
        {
            serviceHandle.get();
        }
        catch ( ExecutionException e )
        {
            LOG.error( "Caught Exception During Execution", e );
        }
        catch ( InterruptedException e )
        {
            LOG.info( "Service Interrupted", e );
        }
    }

    public synchronized void stopExecution()
    {
        serviceHandle.cancel( true );
    }
}

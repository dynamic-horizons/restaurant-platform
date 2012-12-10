package net.dynamichorizons.rp.print;

import java.util.List;

import net.dynamichorizons.rp.domain.order.Order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderPrintExecutor
    implements Runnable
{

    private static final Logger LOG = LoggerFactory.getLogger( OrderPrintExecutor.class );

    private OrderPrintProcessor orderPrintProcessor;

    private OrderPrinterRemoteClient orderPrinterRemoteClient;

    public OrderPrintExecutor( OrderPrintProcessor orderPrintProcessor,
                               OrderPrinterRemoteClient orderPrinterRemoteClient )
    {
        this.orderPrintProcessor = orderPrintProcessor;
        this.orderPrinterRemoteClient = orderPrinterRemoteClient;
    }

    @Override
    public void run()
    {
        LOG.debug( "GETTING ORDERS" );

        List<Order> orders = orderPrinterRemoteClient.getOrdersToPrint();
        if ( orders != null && orders.size() > 0 )
        {
            for ( Order order : orders )
            {
                try
                {
                    // Print The Order
                    this.orderPrintProcessor.printOrder( order );

                    this.orderPrinterRemoteClient.updateOrderPrintDate( order );
                }
                catch ( Exception e )
                {
                    LOG.debug( "Couldn't Print Order", e );
                }
            }
        }
        else
        {
            LOG.debug( "NO ORDERS TO PRINT" );
        }
    }

}
package net.dynamichorizons.rp.service.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dynamichorizons.rp.domain.order.Order;
import net.dynamichorizons.rp.domain.order.OrderPrintRequest;
import net.dynamichorizons.rp.store.order.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nate TODO: Add code to grab orders to be printed, yet haven't in case of queue issues.
 */
@Service
@Transactional( readOnly = true )
public class OrderPrintingServiceImpl
    implements OrderPrintingService
{
    @Autowired
    private OrderRepository orderRepository;

    private Map<Long, Order> orderQueue = Collections.synchronizedMap( new HashMap<Long, Order>() );

    @Override
    public synchronized List<Order> getOrdersToBePrinted()
    {
        return new ArrayList<Order>( orderQueue.values() );
    }

    @Override
    @Transactional
    public synchronized void printOrder( Order order, OrderPrintRequest orderPrintRequest )
    {
        if ( orderPrintRequest.isPrintRequest() )
        {
            orderQueue.put( order.getId(), order );
        }
        else if ( orderPrintRequest.isPrintUpdate() && orderQueue.containsKey( order.getId() ) )
        {
            // Update Print Date
            orderRepository.updatePrintDate( order.getId(), orderPrintRequest.getPrintDateAsDate() );

            // Remove order From Queue
            orderQueue.remove( order.getId() );
        }
    }
}

package net.dynamichorizons.rp.rest.service.order;

import java.util.List;

import net.dynamichorizons.rp.domain.order.CreateOrderRequest;
import net.dynamichorizons.rp.domain.order.Order;
import net.dynamichorizons.rp.domain.order.OrderPrintRequest;

public interface OrderWebService
{
    public Order getCurrentOrder();

    public Order getOrder( Long orderId );

    public Order createOrder( CreateOrderRequest createOrder );

    public void cancelCurrentOrder();

    public List<Order> getOrdersToPrint();

    public void printOrder( Long orderId, OrderPrintRequest orderPrintRequest );

}

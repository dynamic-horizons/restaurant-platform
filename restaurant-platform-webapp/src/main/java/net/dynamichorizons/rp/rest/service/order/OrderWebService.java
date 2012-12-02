package net.dynamichorizons.rp.rest.service.order;

import net.dynamichorizons.rp.domain.order.AddOrderMenuSelectionRequest;
import net.dynamichorizons.rp.domain.order.CreateOrderRequest;
import net.dynamichorizons.rp.domain.order.Order;

public interface OrderWebService
{
    public Order getCurrentOrder();

    public Order createOrder( CreateOrderRequest createOrder );

    public Order addMenuItem( AddOrderMenuSelectionRequest orderMenuSelectionRequest );

    public Order removeMenuItem( Long orderMenuSelectionId );

    public void cancelCurrentOrder();
}

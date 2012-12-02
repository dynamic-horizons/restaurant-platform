package net.dynamichorizons.rp.service.order;

import net.dynamichorizons.rp.domain.exceptions.InvalidDataException;
import net.dynamichorizons.rp.domain.order.AddOrderMenuSelectionRequest;
import net.dynamichorizons.rp.domain.order.CreateOrderRequest;
import net.dynamichorizons.rp.domain.order.Order;

public interface OrderService
{
    public Order getCurrentOrder();

    public Order createOrder( CreateOrderRequest createOrder )
        throws InvalidDataException;

    public Order addMenuItem( AddOrderMenuSelectionRequest orderMenuSelectionRequest )
        throws InvalidDataException;

    public Order removeMenuItem( Long orderMenuSelectionId )
        throws InvalidDataException;

    public void cancelCurrentOrder();
}

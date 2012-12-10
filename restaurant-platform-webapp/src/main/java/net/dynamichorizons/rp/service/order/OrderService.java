package net.dynamichorizons.rp.service.order;

import net.dynamichorizons.rp.domain.exceptions.InvalidDataException;
import net.dynamichorizons.rp.domain.order.CreateOrderRequest;
import net.dynamichorizons.rp.domain.order.Order;
import net.dynamichorizons.rp.domain.order.OrderMenuSelection;

public interface OrderService
{
    public static final String PRINT_BROADCASTER_ID = "/order/print";

    public Order getCurrentOrder();

    public Order getOrder( Long orderId );

    public Order createOrder( CreateOrderRequest createOrder )
        throws InvalidDataException;

    public OrderMenuSelection addOrderMenuSelection( OrderMenuSelection orderMenuSelection )
        throws InvalidDataException;

    public OrderMenuSelection modifyOrderMenuSelection( OrderMenuSelection orderMenuSelection )
        throws InvalidDataException;

    public void removeMenuItem( Long orderMenuSelectionId )
        throws InvalidDataException;

    public void cancelCurrentOrder();

}

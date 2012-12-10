package net.dynamichorizons.rp.service.order;

import java.util.List;

import net.dynamichorizons.rp.domain.order.Order;
import net.dynamichorizons.rp.domain.order.OrderPrintRequest;

public interface OrderPrintingService
{

    public List<Order> getOrdersToBePrinted();

    public void printOrder( Order order, OrderPrintRequest orderPrintRequest );

}

package net.dynamichorizons.rp.domain;

import java.io.Serializable;
import java.util.Map;

import net.dynamichorizons.rp.domain.customer.Customer;
import net.dynamichorizons.rp.domain.order.Order;

public class InitializeApplicationResponse
    implements Serializable
{
    
    private static final long serialVersionUID = 5985048285668708598L;

    private Customer customer;

    private Order currentOrder;

    private Map<String, String> menuMap;

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer( Customer customer )
    {
        this.customer = customer;
    }

    public Order getCurrentOrder()
    {
        return currentOrder;
    }

    public void setCurrentOrder( Order currentOrder )
    {
        this.currentOrder = currentOrder;
    }

    public Map<String, String> getMenuMap()
    {
        return menuMap;
    }

    public void setMenuMap( Map<String, String> menuMap )
    {
        this.menuMap = menuMap;
    }

}

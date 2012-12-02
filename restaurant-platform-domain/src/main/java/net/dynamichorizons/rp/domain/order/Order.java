package net.dynamichorizons.rp.domain.order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.dynamichorizons.rp.domain.base.AbstractEntity;
import net.dynamichorizons.rp.domain.customer.Address;
import net.dynamichorizons.rp.domain.customer.Customer;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table( name = "TBL_ORDER" )
@AttributeOverride( name = "id", column = @Column( name = "ORDER_ID" ) )
public class Order
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = 5634299855367051238L;

    @ManyToOne
    @JoinColumn( name = "CUSTOMER_ID" )
    private Customer customer;
    
    @ManyToOne
    @JoinColumn( name = "ORDER_ADDRESS_ID" )
    private Address orderAddress;
    
    @ManyToOne
    @JoinColumn( name = "DELIVERY_ADDRESS_ID" )
    private Address deliveryAddress;

    @OneToMany( mappedBy = "order", fetch = FetchType.EAGER )
    @Fetch( value = FetchMode.SUBSELECT )
    private List<OrderMenuSelection> orderMenuSelections;

    public Order()
    {
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer( Customer customer )
    {
        this.customer = customer;
    }

    public Address getOrderAddress()
    {
        return orderAddress;
    }

    public void setOrderAddress( Address orderAddress )
    {
        this.orderAddress = orderAddress;
    }

    public Address getDeliveryAddress()
    {
        return deliveryAddress;
    }

    public void setDeliveryAddress( Address deliveryAddress )
    {
        this.deliveryAddress = deliveryAddress;
    }

    public List<OrderMenuSelection> getOrderMenuSelections()
    {
        if ( orderMenuSelections == null )
        {
            orderMenuSelections = new ArrayList<OrderMenuSelection>();
        }
        return orderMenuSelections;
    }

    public void addOrderMenuSelection( OrderMenuSelection orderMenuSelection )
    {
        getOrderMenuSelections().add( orderMenuSelection );
    }

    public void setOrderMenuSelections( List<OrderMenuSelection> orderMenuSelections )
    {
        this.orderMenuSelections = orderMenuSelections;
    }

}

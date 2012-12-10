package net.dynamichorizons.rp.domain.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import net.dynamichorizons.rp.domain.base.AbstractEntity;
import net.dynamichorizons.rp.domain.customer.Address;
import net.dynamichorizons.rp.domain.customer.Customer;
import net.dynamichorizons.rp.domain.customer.PhoneNumber;

import org.codehaus.jackson.annotate.JsonAnySetter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.joda.time.DateTime;

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

    @Column( name = "ORDER_TYPE", nullable = false, length = 32 )
    @NotNull( message = "You must select a valid order type." )
    @Enumerated( EnumType.STRING )
    private OrderType orderType;

    @Column( name = "ORDER_STATUS", nullable = false, length = 32 )
    @NotNull( message = "You must select a valid order type." )
    @Enumerated( EnumType.STRING )
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn( name = "BILLING_ADDRESS_ID" )
    private Address billingAddress;

    @ManyToOne
    @JoinColumn( name = "DELIVERY_ADDRESS_ID" )
    private Address deliveryAddress;

    @ManyToOne
    @JoinColumn( name = "CUSTOMER_PHONE_ID" )
    private PhoneNumber customerPhoneNumber;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "ORDER_DATE" )
    private Date orderDate;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "PRINT_DATE" )
    private Date printDate;

    @Column( name = "IS_ASAP_ORDER", nullable = false )
    private Boolean isAsapOrder;

    @Column( name = "DELIVERY_CHARGE", nullable = true )
    private Double deliveryCharge;

    @Column( name = "SALES_TAX", nullable = true )
    private Double salesTax;

    @Transient
    private Double orderSubTotal;

    @Column( name = "ORDER_TOTAL", nullable = true )
    private Double orderTotal;

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

    public OrderType getOrderType()
    {
        return orderType;
    }

    public void setOrderType( OrderType orderType )
    {
        this.orderType = orderType;
    }

    public OrderStatus getOrderStatus()
    {
        return orderStatus;
    }

    public void setOrderStatus( OrderStatus orderStatus )
    {
        this.orderStatus = orderStatus;
    }

    public Address getBillingAddress()
    {
        return billingAddress;
    }

    public void setBillingAddress( Address billingAddress )
    {
        this.billingAddress = billingAddress;
    }

    public Address getDeliveryAddress()
    {
        return deliveryAddress;
    }

    public void setDeliveryAddress( Address deliveryAddress )
    {
        this.deliveryAddress = deliveryAddress;
    }

    public PhoneNumber getCustomerPhoneNumber()
    {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber( PhoneNumber customerPhoneNumber )
    {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public DateTime getOrderDate()
    {
        return null == orderDate ? null : new DateTime( orderDate );
    }

    public String getOrderDateAsString()
    {
        return getOrderDate().toString( "MM/dd/yyyy hh:mm a" );
    }

    public void setOrderDate( DateTime orderDate )
    {
        this.orderDate = null == orderDate ? null : orderDate.toDate();
    }

    public Boolean isAsapOrder()
    {
        return isAsapOrder;
    }

    public void setIsAsapOrder( Boolean isAsapOrder )
    {
        this.isAsapOrder = isAsapOrder;
    }

    public Double getDeliveryCharge()
    {
        return deliveryCharge;
    }

    public void setDeliveryCharge( Double deliveryCharge )
    {
        this.deliveryCharge = deliveryCharge;
    }

    public Double getSalesTax()
    {
        return salesTax;
    }

    public void setSalesTax( Double salesTax )
    {
        this.salesTax = salesTax;
    }

    public Double getOrderSubTotal()
    {
        return orderSubTotal;
    }

    public void setOrderSubTotal( Double orderSubTotal )
    {
        this.orderSubTotal = orderSubTotal;
    }

    public Double getOrderTotal()
    {
        return orderTotal;
    }

    public void setOrderTotal( Double orderTotal )
    {
        this.orderTotal = orderTotal;
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

    public void removeOrderMenuSelection( OrderMenuSelection orderMenuSelection )
    {
        getOrderMenuSelections().remove( orderMenuSelection );
    }

    public void setOrderMenuSelections( List<OrderMenuSelection> orderMenuSelections )
    {
        this.orderMenuSelections = orderMenuSelections;
    }

    @JsonAnySetter
    public void handleUnknownProperties( String key, Object value )
    {
        if ( key.equals( "asapOrder" ) && value != null )
        {
            setIsAsapOrder( new Boolean( value.toString() ) );
        }
    }
}

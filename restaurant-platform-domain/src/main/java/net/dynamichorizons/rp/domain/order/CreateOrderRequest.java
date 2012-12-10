package net.dynamichorizons.rp.domain.order;

import java.io.Serializable;

import org.joda.time.DateTime;

public class CreateOrderRequest
    implements Serializable
{

    private static final long serialVersionUID = -7573411657361938689L;

    private String orderType;

    private Long phoneNumberKey;

    private Long billingAddressKey;

    private Long deliveryAddressKey;

    private DateTime orderDate;

    private Boolean isAsapOrder;

    public CreateOrderRequest()
    {
    }

    public String getOrderType()
    {
        return orderType;
    }

    public void setOrderType( String orderType )
    {
        this.orderType = orderType;
    }

    public Long getPhoneNumberKey()
    {
        return phoneNumberKey;
    }

    public void setPhoneNumberKey( Long phoneNumberKey )
    {
        this.phoneNumberKey = phoneNumberKey;
    }

    public Long getBillingAddressKey()
    {
        return billingAddressKey;
    }

    public void setBillingAddressKey( Long billingAddressKey )
    {
        this.billingAddressKey = billingAddressKey;
    }

    public Long getDeliveryAddressKey()
    {
        return deliveryAddressKey;
    }

    public void setDeliveryAddressKey( Long deliveryAddressKey )
    {
        this.deliveryAddressKey = deliveryAddressKey;
    }

    public DateTime getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate( DateTime orderDate )
    {
        this.orderDate = orderDate;
    }

    public Boolean isAsapOrder()
    {
        return isAsapOrder;
    }

    public void setIsAsapOrder( Boolean isAsapOrder )
    {
        this.isAsapOrder = isAsapOrder;
    }
}

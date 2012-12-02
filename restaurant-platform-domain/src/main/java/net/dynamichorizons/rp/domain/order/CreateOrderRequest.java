package net.dynamichorizons.rp.domain.order;

import java.io.Serializable;

import org.joda.time.DateTime;

public class CreateOrderRequest
    implements Serializable
{

    private static final long serialVersionUID = -7573411657361938689L;

    private String orderType;

    private long phoneNumberKey;

    private long orderAddressKey;

    private long deliveryAddressKey;

    private DateTime deliveryDate;

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

    public long getPhoneNumberKey()
    {
        return phoneNumberKey;
    }

    public void setPhoneNumberKey( long phoneNumberKey )
    {
        this.phoneNumberKey = phoneNumberKey;
    }

    public long getOrderAddressKey()
    {
        return orderAddressKey;
    }

    public void setOrderAddressKey( long orderAddressKey )
    {
        this.orderAddressKey = orderAddressKey;
    }

    public long getDeliveryAddressKey()
    {
        return deliveryAddressKey;
    }

    public void setDeliveryAddressKey( long deliveryAddressKey )
    {
        this.deliveryAddressKey = deliveryAddressKey;
    }

    public DateTime getDeliveryDate()
    {
        return deliveryDate;
    }

    public void setDeliveryDate( DateTime deliveryDate )
    {
        this.deliveryDate = deliveryDate;
    }

}

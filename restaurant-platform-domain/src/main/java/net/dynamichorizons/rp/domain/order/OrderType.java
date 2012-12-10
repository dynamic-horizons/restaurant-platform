package net.dynamichorizons.rp.domain.order;

public enum OrderType
{
    PICKUP( "pickup" ), DELIVERY( "delivery" ), COURIER( "courier" );

    private String orderTypeKey;

    private OrderType( String orderTypeKey )
    {
        this.orderTypeKey = orderTypeKey;
    }

    public String getOrderTypeKey()
    {
        return orderTypeKey;
    }

    public static OrderType fromOrderTypeKey( String orderTypeKey )
    {
        for ( OrderType orderType : OrderType.values() )
        {
            if ( orderType.getOrderTypeKey().equalsIgnoreCase( orderTypeKey ) )
            {
                return orderType;
            }
        }

        return null;
    }
}

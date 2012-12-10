package net.dynamichorizons.rp.domain.order;

public enum OrderStatus
{
    IN_PROCESS( "in_process" ),
    SUBMITTED( "submitted" ),
    CONFIRMED( "confirmed" ),
    DELIVERED( "delivered" ),
    COMPLETED( "completed" ),
    CANCELLED( "cancelled" );

    private String orderStatusKey;

    private OrderStatus( String orderStatusKey )
    {
        this.orderStatusKey = orderStatusKey;
    }

    public String getOrderStatusKey()
    {
        return orderStatusKey;
    }

    public static OrderStatus fromOrderKey( String orderStatusKey )
    {
        for ( OrderStatus orderStatus : OrderStatus.values() )
        {
            if ( orderStatus.getOrderStatusKey().equalsIgnoreCase( orderStatusKey ) )
            {
                return orderStatus;
            }
        }

        return null;
    }
}

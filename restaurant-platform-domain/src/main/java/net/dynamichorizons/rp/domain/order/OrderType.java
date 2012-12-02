package net.dynamichorizons.rp.domain.order;

public enum OrderType
{
    PICKUP( "pickup" ), DELIVERY( "delivery" ), COURIER( "courier" );
    
    private String orderKey;

    private OrderType( String orderKey )
    {
        this.orderKey = orderKey;
    }

    public String getOrderKey()
    {
        return orderKey;
    }
    
    public static OrderType fromOrderKey(String orderKey) {
        for(OrderType orderType : OrderType.values()) {
            if(orderType.getOrderKey().equals( orderKey )) {
                return orderType;
            }
        }
        
        return null;
    }
}

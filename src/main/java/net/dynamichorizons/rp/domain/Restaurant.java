package net.dynamichorizons.rp.domain;

public class Restaurant
{

    private String restaurantName;

    public Restaurant()
    {
    }

    public Restaurant( String restaurantName )
    {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName()
    {
        return restaurantName;
    }

    public void setRestaurantName( String restaurantName )
    {
        this.restaurantName = restaurantName;
    }

}

package net.dynamichorizons.rp.domain.order;

import java.io.Serializable;

public class AddOrderMenuSelectionRequest
    implements Serializable
{

    private static final long serialVersionUID = -1501918470493721724L;

    private Long menuItemId;

    private Long menuItemSizeId;

    private Integer quantity;
    
    private String comments;

    public Long getMenuItemId()
    {
        return menuItemId;
    }

    public void setMenuItemId( Long menuItemId )
    {
        this.menuItemId = menuItemId;
    }

    public Long getMenuItemSizeId()
    {
        return menuItemSizeId;
    }

    public void setMenuItemSizeId( Long menuItemSizeId )
    {
        this.menuItemSizeId = menuItemSizeId;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity( Integer quantity )
    {
        this.quantity = quantity;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments( String comments )
    {
        this.comments = comments;
    }

}

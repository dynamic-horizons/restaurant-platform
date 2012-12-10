package net.dynamichorizons.rp.domain.order;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.dynamichorizons.rp.domain.base.AbstractEntity;
import net.dynamichorizons.rp.domain.menu.MenuItem;
import net.dynamichorizons.rp.domain.menu.MenuItemSize;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table( name = "TBL_ORDER_MENU_SELECTION" )
@AttributeOverride( name = "id", column = @Column( name = "ORDER_MENU_SELECTION_ID" ) )
public class OrderMenuSelection
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = 4940667815404529675L;

    @ManyToOne
    @JoinColumn( name = "ORDER_ID" )
    protected Order order;

    @Transient
    protected MenuItem selectedMenuItem;

    @Column( name = "MENU_GROUP_ITEM_ID", nullable = true )
    protected Long menuGroupItemId;

    @Transient
    private MenuItemSize selectedMenuItemSize;

    @Column( name = "MENU_ITEM_SIZE_ID", nullable = true )
    protected Long menuItemSizeId;

    @Column( name = "ORDER_MENU_SELECTION_QUANTITY", nullable = false )
    private Integer quantity;

    @Column( name = "ORDER_MENU_SELECTION_COMMENTS", nullable = true, length = 500 )
    private String comments;

    @Column( name = "ORDER_MENU_SELECTION_PRICE", nullable = false )
    private Double price;

    @Column( name = "ORDER_MENU_SELECTION_TOTAL", nullable = false )
    private Double total;

    public OrderMenuSelection()
    {
    }

    @JsonIgnore
    public Order getOrder()
    {
        return order;
    }

    public void setOrder( Order order )
    {
        this.order = order;
    }

    public MenuItem getSelectedMenuItem()
    {
        return selectedMenuItem;
    }

    public void setSelectedMenuItem( MenuItem selectedMenuItem )
    {
        this.selectedMenuItem = selectedMenuItem;
    }

    @JsonIgnore
    public Long getMenuGroupItemId()
    {
        return menuGroupItemId;
    }

    public void setMenuGroupItemId( Long menuGroupItemId )
    {
        this.menuGroupItemId = menuGroupItemId;
    }

    public MenuItemSize getSelectedMenuItemSize()
    {
        return selectedMenuItemSize;
    }

    public void setSelectedMenuItemSize( MenuItemSize selectedMenuItemSize )
    {
        this.selectedMenuItemSize = selectedMenuItemSize;
    }

    @JsonIgnore
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

    public Double getPrice()
    {
        return price;
    }

    public void setPrice( Double price )
    {
        this.price = price;
    }

    public Double getTotal()
    {
        return total;
    }

    public void setTotal( Double total )
    {
        this.total = total;
    }

}

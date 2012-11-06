package net.dynamichorizons.rp.domain.order;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.dynamichorizons.rp.domain.base.AbstractEntity;
import net.dynamichorizons.rp.domain.menu.MenuItem;
import net.dynamichorizons.rp.domain.menu.MenuItemSize;

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

    @ManyToOne
    @JoinColumn( name = "MENU_ITEM_ID" )
    protected MenuItem selectedMenuItem;

    @ManyToOne
    @JoinColumn( name = "MENU_ITEM_SIZE_ID" )
    private MenuItemSize selectedMenuItemSize;

    @Column( name = "ORDER_MENU_SELECTION_COMMENTS", nullable = true, length = 500 )
    private String orderMenuSelectionComments;

    public OrderMenuSelection()
    {
    }

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

    public MenuItemSize getSelectedMenuItemSize()
    {
        return selectedMenuItemSize;
    }

    public void setSelectedMenuItemSize( MenuItemSize selectedMenuItemSize )
    {
        this.selectedMenuItemSize = selectedMenuItemSize;
    }

    public String getOrderMenuSelectionComments()
    {
        return orderMenuSelectionComments;
    }

    public void setOrderMenuSelectionComments( String orderMenuSelectionComments )
    {
        this.orderMenuSelectionComments = orderMenuSelectionComments;
    }

}

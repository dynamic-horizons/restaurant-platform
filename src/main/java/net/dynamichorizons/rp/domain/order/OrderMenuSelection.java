package net.dynamichorizons.rp.domain.order;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import net.dynamichorizons.rp.domain.base.AbstractEntity;
import net.dynamichorizons.rp.domain.menu.MenuItem;
import net.dynamichorizons.rp.domain.menu.MenuItemSize;

@XmlRootElement( name = "order_menu_selection" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "OrderMenuSelection", propOrder = { "selectedMenuItem",
    "selectedMenuItemSize",
    "orderMenuSelectionComments" } )
@Entity
@Table( name = "TBL_ORDER_MENU_SELECTION" )
@AttributeOverride( name = "id", column = @Column( name = "ORDER_MENU_SELECTION_ID" ) )
public class OrderMenuSelection
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = 4940667815404529675L;

    @XmlTransient
    @ManyToOne
    @JoinColumn( name = "ORDER_ID" )
    protected Order parentOrder;

    @XmlElement( name = "order_selected_menu_item" )
    @ManyToOne
    @JoinColumn( name = "MENU_ITEM_UID" )
    protected MenuItem selectedMenuItem;

    @XmlElement( name = "order_selected_menu_item_size" )
    @ManyToOne
    @JoinColumn( name = "MENU_ITEM_SIZE_ID" )
    private MenuItemSize selectedMenuItemSize;

    @XmlElement( name = "order_menu_selection_comments" )
    @Column( name = "ORDER_MENU_SELECTION_COMMENTS", nullable = true, length = 500 )
    private String orderMenuSelectionComments;

    public OrderMenuSelection()
    {
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

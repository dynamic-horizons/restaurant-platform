package net.dynamichorizons.rp.domain.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;

@XmlRootElement( name = "menu_item_size" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "MenuItemSize", propOrder = { "menuItemSizeName",
    "menuItemSizeDescription",
    "menuItemSizePrice",
    "menuItemSizeCalories" } )
@Entity
@Table( name = "TBL_MENU_ITEM_SIZE" )
public class MenuItemSize
{

    @Id
    @XmlAttribute( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "MENU_ITEM_SIZE_ID", unique = true )
    protected Long id;

    @XmlTransient
    @Column( name = "MENU_GROUP_ITEM_ID" )
    protected Long menuGroupItemId;

    @XmlTransient
    @Version
    @Column( name = "OPTLOCK" )
    protected Integer version;

    @XmlElement( name = "menu_item_size_name", required = true )
    @Column( name = "MENU_ITEM_SIZE_NAME", nullable = false, length = 25 )
    protected String menuItemSizeName;

    @XmlElement( name = "menu_item_size_description" )
    @Column( name = "MENU_ITEM_SIZE_DESC", nullable = true, length = 120 )
    protected String menuItemSizeDescription;

    @XmlElement( name = "menu_item_size_calories" )
    @Column( name = "MENU_ITEM_SIZE_CALORIES", nullable = true )
    protected Integer menuItemSizeCalories;

    @XmlElement( name = "menu_item_size_price" )
    @Column( name = "MENU_ITEM_SIZE_PRICE", nullable = true )
    protected Double menuItemSizePrice;

    public MenuItemSize()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public Long getMenuGroupItemId()
    {
        return menuGroupItemId;
    }

    public void setMenuGroupItemId( Long menuGroupItemId )
    {
        this.menuGroupItemId = menuGroupItemId;
    }

    public String getMenuItemSizeName()
    {
        return menuItemSizeName;
    }

    public void setMenuItemSizeName( String menuItemSizeName )
    {
        this.menuItemSizeName = menuItemSizeName;
    }

    public String getMenuItemSizeDescription()
    {
        return menuItemSizeDescription;
    }

    public void setMenuItemSizeDescription( String menuItemSizeDescription )
    {
        this.menuItemSizeDescription = menuItemSizeDescription;
    }

    public Integer getMenuItemSizeCalories()
    {
        return menuItemSizeCalories;
    }

    public void setMenuItemSizeCalories( Integer menuItemSizeCalories )
    {
        this.menuItemSizeCalories = menuItemSizeCalories;
    }

    public Double getMenuItemSizePrice()
    {
        return menuItemSizePrice;
    }

    public void setMenuItemSizePrice( Double menuItemSizePrice )
    {
        this.menuItemSizePrice = menuItemSizePrice;
    }

    public String toString()
    {
        return new ToStringBuilder( this ).append( "id", id ).append( "name", menuItemSizeName ).toString();
    }

}

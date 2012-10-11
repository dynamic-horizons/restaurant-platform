/**
 * Copyright (C) 2012 Dynamic Horizons, LLC <https://www.dynamichorizons.net>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 *   
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package net.dynamichorizons.rp.domain.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.dynamichorizons.rp.domain.UuidXmlAdapter;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@XmlRootElement( name = "menu_item" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "MenuItem", propOrder = { "menuItemName",
    "menuItemDescription",
    "menuItemPrice",
    "menuItemCalories",
    "menuItemAllergyInformation",
    "menuItemHeatIndex",
    "menuItemImageUrls",
    "menuItemSizes",
    "menuItemOptions",
    "menuItemTags" } )
@Entity
@Table( name = "TBL_MENU_ITEM" )
@SecondaryTable( name = "TBL_MENU_GROUP_ITEM", pkJoinColumns = @PrimaryKeyJoinColumn( name = "MENU_ITEM_UID" ) )
public class MenuItem
    implements Serializable
{

    private static final long serialVersionUID = 3133311116453300308L;

    @Id
    @XmlAttribute( name = "uid", required = true )
    @XmlJavaTypeAdapter( UuidXmlAdapter.class )
    @GeneratedValue( generator = "uuid" )
    @GenericGenerator( name = "uuid", strategy = "uuid2" )
    @Column( name = "MENU_ITEM_UID", unique = true, columnDefinition = "BINARY(16)" )
    @Type( type = "uuid-char" )
    protected UUID uid;

    @XmlTransient
    @Version
    @Column( name = "OPTLOCK" )
    protected Integer version;

    @XmlTransient
    @Column( name = "MENU_GROUP_ITEM_ID", table = "TBL_MENU_GROUP_ITEM" )
    protected Long menuGroupItemId;

    @XmlTransient
    @Column( name = "MENU_GROUP_UID", table = "TBL_MENU_GROUP_ITEM", columnDefinition = "BINARY(16)"  )
    @Type( type = "uuid-char" )
    protected UUID menuGroupUid;

    @XmlElement( name = "menu_item_name" )
    @Column( name = "MENU_ITEM_NAME", nullable = true, length = 75 )
    protected String menuItemName;

    @XmlElement( name = "menu_item_description" )
    @Column( name = "MENU_ITEM_DESC", nullable = true, length = 450 )
    protected String menuItemDescription;

    @XmlElement( name = "menu_item_price" )
    @Column( name = "MENU_GROUP_ITEM_PRICE", nullable = true, table = "TBL_MENU_GROUP_ITEM" )
    protected Double menuItemPrice;

    @XmlElement( name = "menu_item_allergy_information" )
    @Embedded
    protected MenuItemAllergyInformation menuItemAllergyInformation;

    @XmlElement( name = "menu_item_calories" )
    @Column( name = "MENU_ITEM_CALORIES", nullable = true )
    protected Integer menuItemCalories;

    @XmlElement( name = "menu_item_heat_index" )
    @Column( name = "MENU_ITEM_HEAT_INDEX", nullable = true )
    protected Integer menuItemHeatIndex;

    @XmlAttribute( name = "disabled" )
    @Column( name = "IS_DISABLED", nullable = true )
    protected Boolean disabled;

    @XmlAttribute( name = "special" )
    @Column( name = "IS_SPECIAL", nullable = true )
    protected Boolean special;

    @XmlAttribute( name = "vegetarian" )
    @Column( name = "IS_VEGETARIAN", nullable = true )
    protected Boolean vegetarian;

    @XmlAttribute( name = "vegan" )
    @Column( name = "IS_VEGAN", nullable = true )
    protected Boolean vegan;

    @XmlAttribute( name = "kosher" )
    @Column( name = "IS_KOSHER", nullable = true )
    protected Boolean kosher;

    @XmlAttribute( name = "halal" )
    @Column( name = "IS_HALAL", nullable = true )
    protected Boolean halal;

    @XmlAttribute( name = "gluten_free" )
    @Column( name = "IS_GLUTEN_FREE", nullable = true )
    protected Boolean glutenFree;

    @XmlElementWrapper(name = "menu_item_image_urls", required = true)
    @XmlElement( name = "menu_item_image_url" )
    @Transient
    protected List<MenuItemImage> menuItemImageUrls;

    @XmlElementWrapper(name = "menu_item_sizes", required = true)
    @XmlElement( name = "menu_item_size" )
    @Transient
    protected List<MenuItemSize> menuItemSizes;

    @XmlElementWrapper(name = "menu_item_options", required = true)
    @XmlElement( name = "menu_item_option" )
    @Transient
    protected List<MenuItemOption> menuItemOptions;

    @XmlElementWrapper(name = "menu_item_tags", required = true)
    @XmlElement( name = "menu_item_tag" )
    @ElementCollection( fetch = FetchType.EAGER )
    @CollectionTable( name = "TBL_MENU_ITEM_TAGS", joinColumns = @JoinColumn( name = "MENU_ITEM_UID" ) )
    @Fetch( value = FetchMode.SELECT )
    @Column( name = "MENU_ITEM_TAG" )
    protected List<String> menuItemTags;

    public MenuItem()
    {
    }

    public UUID getUid()
    {
        return uid;
    }

    public void setUid( UUID uid )
    {
        this.uid = uid;
    }

    public Long getMenuGroupItemId()
    {
        return menuGroupItemId;
    }

    public void setMenuGroupItemId( Long menuGroupItemId )
    {
        this.menuGroupItemId = menuGroupItemId;
    }

    public UUID getMenuGroupUid()
    {
        return menuGroupUid;
    }

    public void setMenuGroupUid( UUID menuGroupUid )
    {
        this.menuGroupUid = menuGroupUid;
    }

    public String getMenuItemName()
    {
        return menuItemName;
    }

    public void setMenuItemName( String menuItemName )
    {
        this.menuItemName = menuItemName;
    }

    public String getMenuItemDescription()
    {
        return menuItemDescription;
    }

    public void setMenuItemDescription( String menuItemDescription )
    {
        this.menuItemDescription = menuItemDescription;
    }

    public Double getMenuItemPrice()
    {
        return menuItemPrice;
    }

    public void setMenuItemPrice( Double menuItemPrice )
    {
        this.menuItemPrice = menuItemPrice;
    }

    public MenuItemAllergyInformation getMenuItemAllergyInformation()
    {
        return menuItemAllergyInformation;
    }

    public void setMenuItemAllergyInformation( MenuItemAllergyInformation menuItemAllergyInformation )
    {
        this.menuItemAllergyInformation = menuItemAllergyInformation;
    }

    public Integer getMenuItemCalories()
    {
        return menuItemCalories;
    }

    public void setMenuItemCalories( Integer menuItemCalories )
    {
        this.menuItemCalories = menuItemCalories;
    }

    public Integer getMenuItemHeatIndex()
    {
        return menuItemHeatIndex;
    }

    public void setMenuItemHeatIndex( Integer menuItemHeatIndex )
    {
        this.menuItemHeatIndex = menuItemHeatIndex;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled( Boolean disabled )
    {
        this.disabled = disabled;
    }

    public Boolean getSpecial()
    {
        return special;
    }

    public void setSpecial( Boolean special )
    {
        this.special = special;
    }

    public Boolean getVegetarian()
    {
        return vegetarian;
    }

    public void setVegetarian( Boolean vegetarian )
    {
        this.vegetarian = vegetarian;
    }

    public Boolean getVegan()
    {
        return vegan;
    }

    public void setVegan( Boolean vegan )
    {
        this.vegan = vegan;
    }

    public Boolean getKosher()
    {
        return kosher;
    }

    public void setKosher( Boolean kosher )
    {
        this.kosher = kosher;
    }

    public Boolean getHalal()
    {
        return halal;
    }

    public void setHalal( Boolean halal )
    {
        this.halal = halal;
    }

    public Boolean getGlutenFree()
    {
        return glutenFree;
    }

    public void setGlutenFree( Boolean glutenFree )
    {
        this.glutenFree = glutenFree;
    }

    public List<MenuItemImage> getMenuItemImageUrls()
    {
        if ( menuItemImageUrls == null )
        {
            menuItemImageUrls = new ArrayList<MenuItemImage>();
        }
        return menuItemImageUrls;
    }

    public void setMenuItemImageUrls( List<MenuItemImage> menuItemImageUrls )
    {
        this.menuItemImageUrls = menuItemImageUrls;
    }

    public List<MenuItemSize> getMenuItemSizes()
    {
        if ( menuItemSizes == null )
        {
            menuItemSizes = new ArrayList<MenuItemSize>();
        }
        return menuItemSizes;
    }

    public void setMenuItemSizes( List<MenuItemSize> menuItemSizes )
    {
        this.menuItemSizes = menuItemSizes;
    }

    public List<MenuItemOption> getMenuItemOptions()
    {
        if ( menuItemOptions == null )
        {
            menuItemOptions = new ArrayList<MenuItemOption>();
        }
        return menuItemOptions;
    }

    public void setMenuItemOptions( List<MenuItemOption> menuItemOptions )
    {
        this.menuItemOptions = menuItemOptions;
    }

    public List<String> getMenuItemTags()
    {
        if ( menuItemTags == null )
        {
            menuItemTags = new ArrayList<String>();
        }
        return menuItemTags;
    }

    public void setMenuItemTags( List<String> menuItemTags )
    {
        this.menuItemTags = menuItemTags;
    }

    public String toString()
    {
        return new ToStringBuilder( this ).append( "uid", uid ).append( "name", menuItemName ).append( "menuItemSizes",
                                                                                                       getMenuItemSizes() ).toString();
    }
}

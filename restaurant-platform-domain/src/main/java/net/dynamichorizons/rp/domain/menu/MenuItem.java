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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table( name = "TBL_MENU_ITEM" )
@AttributeOverride( name = "id", column = @Column( name = "MENU_ITEM_ID" ) )
@SecondaryTable( name = "TBL_MENU_GROUP_ITEM", pkJoinColumns = @PrimaryKeyJoinColumn( name = "MENU_ITEM_ID" ) )
public class MenuItem
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = 3133311116453300308L;

    @Column( name = "MENU_GROUP_ITEM_ID", table = "TBL_MENU_GROUP_ITEM" )
    protected Long menuGroupItemId;

    @Column( name = "MENU_GROUP_ID", table = "TBL_MENU_GROUP_ITEM" )
    protected Long menuGroupId;

    @Column( name = "MENU_ITEM_NAME", nullable = true, length = 75 )
    protected String menuItemName;

    @Column( name = "MENU_ITEM_DESC", nullable = true, length = 450 )
    protected String menuItemDescription;

    @Column( name = "MENU_GROUP_ITEM_PRICE", nullable = true, table = "TBL_MENU_GROUP_ITEM" )
    protected Double menuItemPrice;

    @Embedded
    protected MenuItemAllergyInformation menuItemAllergyInformation;

    @Column( name = "MENU_ITEM_CALORIES", nullable = true )
    protected Integer menuItemCalories;

    @Column( name = "MENU_ITEM_HEAT_INDEX", nullable = true )
    protected Integer menuItemHeatIndex;

    @Column( name = "IS_DISABLED", nullable = true )
    protected Boolean disabled;

    @Column( name = "IS_SPECIAL", nullable = true )
    protected Boolean special;

    @Column( name = "IS_VEGETARIAN", nullable = true )
    protected Boolean vegetarian;

    @Column( name = "IS_VEGAN", nullable = true )
    protected Boolean vegan;

    @Column( name = "IS_KOSHER", nullable = true )
    protected Boolean kosher;

    @Column( name = "IS_HALAL", nullable = true )
    protected Boolean halal;

    @Column( name = "IS_GLUTEN_FREE", nullable = true )
    protected Boolean glutenFree;

    @Transient
    protected List<MenuItemImage> menuItemImageUrls;

    @Transient
    protected List<MenuItemSize> menuItemSizes;

    @Transient
    protected List<MenuItemOption> menuItemOptions;

    @ElementCollection( fetch = FetchType.EAGER )
    @CollectionTable( name = "TBL_MENU_ITEM_TAGS", joinColumns = @JoinColumn( name = "MENU_ITEM_ID" ) )
    @Fetch( value = FetchMode.SELECT )
    @Column( name = "MENU_ITEM_TAG" )
    protected List<String> menuItemTags;

    public MenuItem()
    {
    }

    public Long getMenuGroupItemId()
    {
        return menuGroupItemId;
    }

    public void setMenuGroupItemId( Long menuGroupItemId )
    {
        this.menuGroupItemId = menuGroupItemId;
    }

    public Long getMenuGroupId()
    {
        return menuGroupId;
    }

    public void setMenuGroupId( Long menuGroupId )
    {
        this.menuGroupId = menuGroupId;
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
        return new ToStringBuilder( this ).append( "uid", getId() ).append( "name", menuItemName ).append( "menuItemSizes",
                                                                                                           getMenuItemSizes() ).toString();
    }
}

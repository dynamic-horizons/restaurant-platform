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

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table( name = "TBL_MENU_ITEM_SIZE" )
@AttributeOverride( name = "id", column = @Column( name = "MENU_ITEM_SIZE_ID" ) )
public class MenuItemSize
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = -1747431564543309161L;

    @Column( name = "MENU_GROUP_ITEM_ID" )
    protected Long menuGroupItemId;

    @Column( name = "MENU_ITEM_SIZE_NAME", nullable = false, length = 25 )
    protected String menuItemSizeName;

    @Column( name = "MENU_ITEM_SIZE_DESC", nullable = true, length = 120 )
    protected String menuItemSizeDescription;

    @Column( name = "MENU_ITEM_SIZE_CALORIES", nullable = true )
    protected Integer menuItemSizeCalories;

    @Column( name = "MENU_ITEM_SIZE_PRICE", nullable = true )
    protected Double menuItemSizePrice;

    public MenuItemSize()
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
        return new ToStringBuilder( this ).append( "id", getId() ).append( "name", menuItemSizeName ).toString();
    }

}

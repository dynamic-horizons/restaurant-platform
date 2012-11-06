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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

@Entity
@Table( name = "TBL_MENU_ITEM_OPTION" )
@AttributeOverride( name = "id", column = @Column( name = "MENU_ITEM_OPTION_ID" ) )
@SecondaryTable( name = "TBL_MENU_GROUP_ITEM", pkJoinColumns = @PrimaryKeyJoinColumn( name = "MENU_GROUP_ITEM_ID" ) )
public class MenuItemOption
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = -9148352208516726497L;

    @Column( name = "MENU_GROUP_ITEM_ID" )
    protected Long menuGroupItemId;

    @ManyToOne
    @JoinColumn( name = "MENU_ITEM_ID", table = "TBL_MENU_GROUP_ITEM" )
    protected MenuItem parentMenuItem;

    @Column( name = "MENU_ITEM_OPTION_NAME", nullable = false, length = 50 )
    protected String name;

    @Column( name = "MENU_ITEM_OPTION_INFO", nullable = true, length = 255 )
    protected String menuItemOptionInformation;

    @Column( name = "MENU_ITEM_OPTION_MIN_SELECTED", nullable = true )
    protected Integer minSelected;

    @Column( name = "MENU_ITEM_OPTION_MAX_SELECTED", nullable = true )
    protected Integer maxSelected;

    @OneToMany( mappedBy = "parentMenuItemOption" )
    protected List<MenuItemOptionItem> menuItemOptionItems;

    public MenuItemOption()
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

    @JsonIgnore
    public MenuItem getParentMenuItem()
    {
        return parentMenuItem;
    }

    public void setParentMenuItem( MenuItem parentMenuItem )
    {
        this.parentMenuItem = parentMenuItem;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getMenuItemOptionInformation()
    {
        return menuItemOptionInformation;
    }

    public void setMenuItemOptionInformation( String menuItemOptionInformation )
    {
        this.menuItemOptionInformation = menuItemOptionInformation;
    }

    public Integer getMinSelected()
    {
        return minSelected;
    }

    public void setMinSelected( Integer minSelected )
    {
        this.minSelected = minSelected;
    }

    public Integer getMaxSelected()
    {
        return maxSelected;
    }

    public void setMaxSelected( Integer maxSelected )
    {
        this.maxSelected = maxSelected;
    }

    public List<MenuItemOptionItem> getMenuItemOptionItems()
    {
        if ( menuItemOptionItems == null )
        {
            menuItemOptionItems = new ArrayList<MenuItemOptionItem>();
        }
        return this.menuItemOptionItems;
    }

    public void setMenuItemOptionItems( List<MenuItemOptionItem> menuItemOptionItems )
    {
        this.menuItemOptionItems = menuItemOptionItems;
    }

}

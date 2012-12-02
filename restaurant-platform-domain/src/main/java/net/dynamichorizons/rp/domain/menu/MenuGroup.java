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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table( name = "TBL_MENU_GROUP" )
@AttributeOverride( name = "id", column = @Column( name = "MENU_GROUP_ID" ) )
public class MenuGroup
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = -229485181478103996L;

    @ManyToOne
    @JoinColumn( name = "MENU_ID" )
    protected Menu parentMenu;

    @Column( name = "MENU_GROUP_NAME", nullable = false, length = 50 )
    protected String name;

    @Column( name = "MENU_GROUP_DESC", nullable = true, length = 255 )
    protected String menuGroupDescription;

    @Column( name = "MENU_GROUP_NOTE", nullable = true, length = 255 )
    protected String menuGroupNote;

    @Column( name = "IS_DISABLED", nullable = true )
    protected Boolean disabled;

    @Column( name = "ORDER_BY" )
    protected Integer orderBy;

    @Transient
    protected List<MenuItem> menuItems;

    @OneToMany( fetch = FetchType.EAGER )
    @JoinColumn( name = "MENU_GROUP_ID" )
    @Fetch( value = FetchMode.SELECT )
    protected List<MenuGroupOption> menuGroupOptions;

    public MenuGroup()
    {
    }

    @JsonIgnore
    public Menu getParentMenu()
    {
        return parentMenu;
    }

    public void setParentMenu( Menu parentMenu )
    {
        this.parentMenu = parentMenu;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getMenuGroupDescription()
    {
        return menuGroupDescription;
    }

    public void setMenuGroupDescription( String menuGroupDescription )
    {
        this.menuGroupDescription = menuGroupDescription;
    }

    public String getMenuGroupNote()
    {
        return menuGroupNote;
    }

    public void setMenuGroupNote( String menuGroupNote )
    {
        this.menuGroupNote = menuGroupNote;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled( Boolean disabled )
    {
        this.disabled = disabled;
    }

    public Integer getOrderBy()
    {
        return orderBy;
    }

    public void setOrderBy( Integer orderBy )
    {
        this.orderBy = orderBy;
    }

    public List<MenuItem> getMenuItems()
    {
        if ( menuItems == null )
        {
            menuItems = new ArrayList<MenuItem>();
        }
        return menuItems;
    }

    public void setMenuItems( List<MenuItem> menuItems )
    {
        this.menuItems = menuItems;
    }

    public List<MenuGroupOption> getMenuGroupOptions()
    {
        if ( menuGroupOptions == null )
        {
            menuGroupOptions = new ArrayList<MenuGroupOption>();
        }
        return menuGroupOptions;
    }

    public void setMenuGroupOptions( List<MenuGroupOption> menuGroupOptions )
    {
        this.menuGroupOptions = menuGroupOptions;
    }

    public String toString()
    {
        return new ToStringBuilder( this ).append( "id", getId() ).append( "name", name ).append( "menuItems",
                                                                                                  getMenuItems() ).toString();
    }
}

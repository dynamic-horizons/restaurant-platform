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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement( name = "menu_item_option" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "MenuItemOption", propOrder = { "menuItemOptionInformation", "menuItemOptionItems" } )
@Entity
@Table( name = "TBL_MENU_ITEM_OPTION" )
@SecondaryTable( name = "TBL_MENU_GROUP_ITEM", pkJoinColumns = @PrimaryKeyJoinColumn( name = "MENU_GROUP_ITEM_ID" ) )
public class MenuItemOption
{

    @Id
    @XmlAttribute( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "MENU_ITEM_OPTION_ID", unique = true )
    protected Long id;
    
    @XmlTransient
    @Column( name = "MENU_GROUP_ITEM_ID" )
    protected Long menuGroupItemId;

    @XmlTransient
    @Version
    @Column( name = "OPTLOCK" )
    protected Integer version;

    @XmlTransient
    @ManyToOne
    @JoinColumn( name = "MENU_ITEM_UID", table = "TBL_MENU_GROUP_ITEM" )
    protected MenuItem parentMenuItem;

    @XmlAttribute( name = "name", required = true )
    @Column( name = "MENU_ITEM_OPTION_NAME", nullable = false, length = 50 )
    protected String name;
    
    @XmlElement( name = "menu_item_option_information", required = true )
    @Column( name = "MENU_ITEM_OPTION_INFO", nullable = true, length = 255 )
    protected String menuItemOptionInformation;

    @XmlAttribute( name = "min_selected" )
    @Column( name = "MENU_ITEM_OPTION_MIN_SELECTED", nullable = true )
    protected Integer minSelected;

    @XmlAttribute( name = "max_selected" )
    @Column( name = "MENU_ITEM_OPTION_MAX_SELECTED", nullable = true )
    protected Integer maxSelected;

    @XmlElementWrapper(name = "menu_item_option_items", required = true)
    @XmlElement( name = "menu_item_option_item" )
    @OneToMany( mappedBy = "parentMenuItemOption" )
    protected List<MenuItemOptionItem> menuItemOptionItems;

    public MenuItemOption()
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

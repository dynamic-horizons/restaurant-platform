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

@XmlRootElement( name = "menu_item_option_item" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "MenuItemOptionItem", propOrder = { "menuItemOptionName", "menItemOptionAdditionalCost" } )
@Entity
@Table( name = "TBL_MENU_ITEM_OPTION_ITEM" )
@AttributeOverride( name = "id", column = @Column( name = "MENU_ITEM_OPTION_ITEM_ID" ) )
public class MenuItemOptionItem
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = 4966934936618204569L;

    @XmlTransient
    @ManyToOne
    @JoinColumn( name = "MENU_ITEM_OPTION_ID" )
    protected MenuItemOption parentMenuItemOption;

    @XmlElement( name = "menu_item_option_name", required = true )
    @Column( name = "MENU_ITEM_OPTION_NAME" )
    protected String menuItemOptionName;

    @XmlElement( name = "menu_item_option_additional_cost" )
    @Column( name = "MENU_ITEM_OPTION_ADDITIONAL_COST" )
    protected Double menItemOptionAdditionalCost;

    public MenuItemOptionItem()
    {
    }

    public MenuItemOption getParentMenuItemOption()
    {
        return parentMenuItemOption;
    }

    public void setParentMenuItemOption( MenuItemOption parentMenuItemOption )
    {
        this.parentMenuItemOption = parentMenuItemOption;
    }

    public String getMenuItemOptionName()
    {
        return menuItemOptionName;
    }

    public void setMenuItemOptionName( String menuItemOptionName )
    {
        this.menuItemOptionName = menuItemOptionName;
    }

    public Double getMenItemOptionAdditionalCost()
    {
        return menItemOptionAdditionalCost;
    }

    public void setMenItemOptionAdditionalCost( Double menItemOptionAdditionalCost )
    {
        this.menItemOptionAdditionalCost = menItemOptionAdditionalCost;
    }

}

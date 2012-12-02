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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

@Entity
@AttributeOverride( name = "id", column = @Column( name = "MENU_GROUP_OPTION_ID" ) )
@Table( name = "TBL_MENU_GROUP_OPTION" )
public class MenuGroupOption
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = 3543542167300762228L;

    @Column( name = "MENU_GROUP_OPTION_NAME", nullable = true, length = 50 )
    protected String name;

    @Column( name = "MENU_GROUP_OPTION_INFO", nullable = true, length = 255 )
    protected String menuGroupOptionInformation;

    @Column( name = "MENU_GROUP_OPTION_MIN_SELECTED", nullable = true )
    protected Integer minSelected;

    @Column( name = "MENU_GROUP_OPTION_MAX_SELECTED", nullable = true )
    protected Integer maxSelected;

    @OneToMany( mappedBy = "parentMenuGroupOption" )
    protected List<MenuGroupOptionItem> menuGroupOptionItems;

    public MenuGroupOption()
    {
    }

    /**
     * Gets the value of the menuGroupOptionInformation property.
     * 
     * @return possible object is {@link String }
     */
    public String getMenuGroupOptionInformation()
    {
        return menuGroupOptionInformation;
    }

    /**
     * Sets the value of the menuGroupOptionInformation property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setMenuGroupOptionInformation( String value )
    {
        this.menuGroupOptionInformation = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return possible object is {@link String }
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setName( String value )
    {
        this.name = value;
    }

    /**
     * Gets the value of the minSelected property.
     * 
     * @return possible object is {@link Integer }
     */
    public Integer getMinSelected()
    {
        return minSelected;
    }

    /**
     * Sets the value of the minSelected property.
     * 
     * @param value allowed object is {@link Integer }
     */
    public void setMinSelected( Integer value )
    {
        this.minSelected = value;
    }

    /**
     * Gets the value of the maxSelected property.
     * 
     * @return possible object is {@link Integer }
     */
    public Integer getMaxSelected()
    {
        return maxSelected;
    }

    /**
     * Sets the value of the maxSelected property.
     * 
     * @param value allowed object is {@link Integer }
     */
    public void setMaxSelected( Integer value )
    {
        this.maxSelected = value;
    }

    public List<MenuGroupOptionItem> getMenuGroupOptionItems()
    {
        if ( menuGroupOptionItems == null )
        {
            menuGroupOptionItems = new ArrayList<MenuGroupOptionItem>();
        }
        return menuGroupOptionItems;
    }

    public void setMenuGroupOptionItems( List<MenuGroupOptionItem> menuGroupOptionItems )
    {
        this.menuGroupOptionItems = menuGroupOptionItems;
    }

}

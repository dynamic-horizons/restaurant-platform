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
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table( name = "TBL_MENU" )
@AttributeOverride( name = "id", column = @Column( name = "MENU_ID" ) )
public class Menu
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = 7126859430093600619L;

    @Column( name = "MENU_NAME", nullable = false, length = 50 )
    protected String name;

    @Column( name = "MENU_KEY", nullable = false, length = 50 )
    protected String menuKey;

    @Column( name = "MENU_DESC", nullable = true, length = 255 )
    protected String menuDescription;

    @Column( name = "MENU_NOTE", nullable = true, length = 255 )
    protected String menuNote;

    @Column( name = "MENU_CURRENCY_SYMBOL", nullable = false, length = 3 )
    protected String currencySymbol;

    @Column( name = "MENU_LANGUAGE", nullable = true, length = 2 )
    protected String language;

    @Embedded
    protected MenuDuration menuDuration;
    
    @OneToMany( mappedBy = "parentMenu", fetch = FetchType.EAGER )
    @OrderBy( "orderBy ASC" )
    @Fetch( value = FetchMode.SELECT )
    protected List<MenuGroup> menuGroups;

    public Menu()
    {
    }

    /**
     * Gets the value of the menuDescription property.
     * 
     * @return possible object is {@link String }
     */
    public String getMenuDescription()
    {
        return menuDescription;
    }

    /**
     * Sets the value of the menuDescription property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setMenuDescription( String value )
    {
        this.menuDescription = value;
    }

    public String getMenuNote()
    {
        return this.menuNote;
    }

    public void setMenuNote( String menuNote )
    {
        this.menuNote = menuNote;
    }

    public String getMenuKey()
    {
        return menuKey;
    }

    public void setMenuKey( String menuKey )
    {
        this.menuKey = menuKey;
    }

    /**
     * Gets the value of the menuDuration property.
     * 
     * @return possible object is {@link MenuDuration }
     */
    public MenuDuration getMenuDuration()
    {
        return menuDuration;
    }

    /**
     * Sets the value of the menuDuration property.
     * 
     * @param value allowed object is {@link MenuDuration }
     */
    public void setMenuDuration( MenuDuration value )
    {
        this.menuDuration = value;
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
     * Gets the value of the currencySymbol property.
     * 
     * @return possible object is {@link String }
     */
    public String getCurrencySymbol()
    {
        return currencySymbol;
    }

    /**
     * Sets the value of the currencySymbol property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setCurrencySymbol( String value )
    {
        this.currencySymbol = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return possible object is {@link String }
     */
    public String getLanguage()
    {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setLanguage( String value )
    {
        this.language = value;
    }

    public List<MenuGroup> getMenuGroups()
    {
        if ( menuGroups == null )
        {
            menuGroups = new ArrayList<MenuGroup>();
        }
        return menuGroups;
    }

    public void setMenuGroups( List<MenuGroup> menuGroups )
    {
        this.menuGroups = menuGroups;
    }

    public String toString()
    {
        return new ToStringBuilder( this ).append( "id", getId() ).append( "name", name ).append( "menuKey", menuKey ).append( "menuGroups",
                                                                                                                               getMenuGroups() ).toString();
    }
}

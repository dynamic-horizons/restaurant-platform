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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

@XmlRootElement( name = "menu_group_option" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "MenuGroupOption", propOrder = { "menuGroupOptionInformation", "menuGroupOptionItems" } )
@Entity
@Table( name = "TBL_MENU_GROUP_OPTION" )
public class MenuGroupOption
    implements Serializable
{

    private static final long serialVersionUID = 3543542167300762228L;

    @Id
    @XmlAttribute( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "MENU_GROUP_OPTION_ID", unique = true )
    protected Long id;

    @XmlTransient
    @Version
    @Column( name = "OPTLOCK" )
    protected Integer version;

    @XmlAttribute( name = "name", required = true )
    @Column( name = "MENU_GROUP_OPTION_NAME", nullable = true, length = 50 )
    protected String name;

    @XmlElement( name = "menu_group_option_information", required = true )
    @Column( name = "MENU_GROUP_OPTION_INFO", nullable = true, length = 255 )
    protected String menuGroupOptionInformation;
    
    @XmlAttribute( name = "min_selected" )
    @Column( name = "MENU_GROUP_OPTION_MIN_SELECTED", nullable = true )
    protected Integer minSelected;

    @XmlAttribute( name = "max_selected" )
    @Column( name = "MENU_GROUP_OPTION_MAX_SELECTED", nullable = true )
    protected Integer maxSelected;

    @XmlElementWrapper(name = "menu_group_option_items", required = true)
    @XmlElement( name = "menu_group_option_item" )
    @OneToMany( mappedBy = "parentMenuGroupOption" )
    protected List<MenuGroupOptionItem> menuGroupOptionItems;

    public MenuGroupOption()
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

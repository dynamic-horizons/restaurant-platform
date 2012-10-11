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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement( name = "menu_group_option_item" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "MenuGroupOptionItem", propOrder = { "menuGroupOptionName", "menuGroupOptionAdditionalCost" } )
@Entity
@Table( name = "TBL_MENU_GROUP_OPTION_ITEM" )
public class MenuGroupOptionItem
{

    @Id
    @XmlAttribute( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "MENU_GROUP_OPTION_ITEM_ID", unique = true )
    protected Long id;

    @XmlTransient
    @Version
    @Column( name = "OPTLOCK" )
    protected Integer version;

    @XmlTransient
    @ManyToOne
    @JoinColumn( name = "MENU_GROUP_OPTION_UID" )
    protected MenuGroupOption parentMenuGroupOption;

    @XmlElement( name = "menu_group_option_name", required = true )
    @Column( name = "MENU_GROUP_OPTION_ITEM_NAME" )
    protected String menuGroupOptionName;

    @XmlElement( name = "menu_group_option_additional_cost" )
    @Column( name = "MENU_GROUP_OPTION_ITEM_ADDL_COST" )
    protected Double menuGroupOptionAdditionalCost;

    public MenuGroupOptionItem()
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

    public MenuGroupOption getParentMenuGroupOption()
    {
        return parentMenuGroupOption;
    }

    public void setParentMenuGroupOption( MenuGroupOption parentMenuGroupOption )
    {
        this.parentMenuGroupOption = parentMenuGroupOption;
    }

    /**
     * Gets the value of the menuGroupOptionName property.
     * 
     * @return possible object is {@link String }
     */
    public String getMenuGroupOptionName()
    {
        return menuGroupOptionName;
    }

    /**
     * Sets the value of the menuGroupOptionName property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setMenuGroupOptionName( String value )
    {
        this.menuGroupOptionName = value;
    }

    /**
     * Gets the value of the menuGroupOptionAdditionalCost property.
     * 
     * @return possible object is {@link Double }
     */
    public Double getMenuGroupOptionAdditionalCost()
    {
        return menuGroupOptionAdditionalCost;
    }

    /**
     * Sets the value of the menuGroupOptionAdditionalCost property.
     * 
     * @param value allowed object is {@link Double }
     */
    public void setMenuGroupOptionAdditionalCost( Double value )
    {
        this.menuGroupOptionAdditionalCost = value;
    }

}

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
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "", propOrder = { "value" } )
@Embeddable
public class MenuItemAllergyInformation
{

    @XmlValue
    @Column( name = "MENU_ITEM_ALLERGY_INFORMATION", nullable = true, length = 450 )
    protected String value;

    @XmlAttribute( name = "allergens" )
    @Column( name = "MENU_ITEM_ALLERGENS", nullable = true, length = 255 )
    protected String allergens;

    public MenuItemAllergyInformation()
    {
    }

    /**
     * Gets the value of the value property.
     * 
     * @return possible object is {@link String }
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setValue( String value )
    {
        this.value = value;
    }

    /**
     * Gets the value of the allergens property.
     * 
     * @return possible object is {@link String }
     */
    public String getAllergens()
    {
        return allergens;
    }

    /**
     * Sets the value of the allergens property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setAllergens( String value )
    {
        this.allergens = value;
    }
}

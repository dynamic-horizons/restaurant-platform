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
package net.dynamichorizons.rp.domain;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for OpenMenu complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpenMenu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="crosswalks" type="{http://openmenu.org/schema}Crosswalks" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "OpenMenu", propOrder = { "version", "crosswalks" } )
public class OpenMenu
{

    @XmlElement( required = true )
    protected BigDecimal version;

    protected Crosswalks crosswalks;

    /**
     * Gets the value of the version property.
     * 
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getVersion()
    {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value allowed object is {@link BigDecimal }
     */
    public void setVersion( BigDecimal value )
    {
        this.version = value;
    }

    /**
     * Gets the value of the crosswalks property.
     * 
     * @return possible object is {@link Crosswalks }
     */
    public Crosswalks getCrosswalks()
    {
        return crosswalks;
    }

    /**
     * Sets the value of the crosswalks property.
     * 
     * @param value allowed object is {@link Crosswalks }
     */
    public void setCrosswalks( Crosswalks value )
    {
        this.crosswalks = value;
    }

}

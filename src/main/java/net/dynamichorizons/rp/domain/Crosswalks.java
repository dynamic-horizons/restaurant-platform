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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Crosswalks complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Crosswalks">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="crosswalk_id" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\w+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="crosswalk_name" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="crosswalk_url" type="{http://openmenu.org/schema}UrlType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Crosswalks", propOrder = { "crosswalkId", "crosswalkName", "crosswalkUrl" } )
public class Crosswalks
{

    @XmlElement( name = "crosswalk_id" )
    protected String crosswalkId;

    @XmlElement( name = "crosswalk_name" )
    protected String crosswalkName;

    @XmlElement( name = "crosswalk_url" )
    protected String crosswalkUrl;

    /**
     * Gets the value of the crosswalkId property.
     * 
     * @return possible object is {@link String }
     */
    public String getCrosswalkId()
    {
        return crosswalkId;
    }

    /**
     * Sets the value of the crosswalkId property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setCrosswalkId( String value )
    {
        this.crosswalkId = value;
    }

    /**
     * Gets the value of the crosswalkName property.
     * 
     * @return possible object is {@link String }
     */
    public String getCrosswalkName()
    {
        return crosswalkName;
    }

    /**
     * Sets the value of the crosswalkName property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setCrosswalkName( String value )
    {
        this.crosswalkName = value;
    }

    /**
     * Gets the value of the crosswalkUrl property.
     * 
     * @return possible object is {@link String }
     */
    public String getCrosswalkUrl()
    {
        return crosswalkUrl;
    }

    /**
     * Sets the value of the crosswalkUrl property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setCrosswalkUrl( String value )
    {
        this.crosswalkUrl = value;
    }

}

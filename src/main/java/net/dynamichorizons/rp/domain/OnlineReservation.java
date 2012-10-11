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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for OnlineReservation complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OnlineReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="online_reservation_name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="2"/>
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="online_reservation_url" type="{http://openmenu.org/schema}UrlType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{http://openmenu.org/schema}OnlineType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "OnlineReservation", propOrder = { "onlineReservationName", "onlineReservationUrl" } )
public class OnlineReservation
{

    @XmlElement( name = "online_reservation_name", required = true )
    protected String onlineReservationName;

    @XmlElement( name = "online_reservation_url", required = true )
    protected String onlineReservationUrl;

    @XmlAttribute( name = "type", required = true )
    protected OnlineType type;

    /**
     * Gets the value of the onlineReservationName property.
     * 
     * @return possible object is {@link String }
     */
    public String getOnlineReservationName()
    {
        return onlineReservationName;
    }

    /**
     * Sets the value of the onlineReservationName property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setOnlineReservationName( String value )
    {
        this.onlineReservationName = value;
    }

    /**
     * Gets the value of the onlineReservationUrl property.
     * 
     * @return possible object is {@link String }
     */
    public String getOnlineReservationUrl()
    {
        return onlineReservationUrl;
    }

    /**
     * Sets the value of the onlineReservationUrl property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setOnlineReservationUrl( String value )
    {
        this.onlineReservationUrl = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return possible object is {@link OnlineType }
     */
    public OnlineType getType()
    {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value allowed object is {@link OnlineType }
     */
    public void setType( OnlineType value )
    {
        this.type = value;
    }

}

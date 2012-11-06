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
package net.dynamichorizons.rp.domain.restaurant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.dynamichorizons.rp.util.DateTimeXmlAdapter;

import org.joda.time.DateTime;

/**
 * <p>
 * Java class for OperatingDay complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperatingDay">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="day_of_week" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="open_time" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="close_time" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "OperatingDay", propOrder = { "dayOfWeek", "openTime", "closeTime" } )
public class OperatingDay
{

    @XmlElement( name = "day_of_week" )
    protected int dayOfWeek;

    @XmlElement( name = "open_time", required = true, type = String.class )
    @XmlJavaTypeAdapter( DateTimeXmlAdapter.class )
    @XmlSchemaType( name = "dateTime" )
    protected DateTime openTime;

    @XmlElement( name = "close_time", required = true, type = String.class )
    @XmlJavaTypeAdapter( DateTimeXmlAdapter.class )
    @XmlSchemaType( name = "dateTime" )
    protected DateTime closeTime;

    /**
     * Gets the value of the dayOfWeek property.
     */
    public int getDayOfWeek()
    {
        return dayOfWeek;
    }

    /**
     * Sets the value of the dayOfWeek property.
     */
    public void setDayOfWeek( int value )
    {
        this.dayOfWeek = value;
    }

    /**
     * Gets the value of the openTime property.
     * 
     * @return possible object is {@link String }
     */
    public DateTime getOpenTime()
    {
        return openTime;
    }

    /**
     * Sets the value of the openTime property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setOpenTime( DateTime value )
    {
        this.openTime = value;
    }

    /**
     * Gets the value of the closeTime property.
     * 
     * @return possible object is {@link String }
     */
    public DateTime getCloseTime()
    {
        return closeTime;
    }

    /**
     * Sets the value of the closeTime property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setCloseTime( DateTime value )
    {
        this.closeTime = value;
    }

}

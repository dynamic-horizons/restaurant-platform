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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.dynamichorizons.rp.domain.menu.Menu;

import org.joda.time.DateTime;

/**
 * <p>
 * Java class for OpenMenuFormat complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpenMenuFormat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="openmenu" type="{http://openmenu.org/schema}OpenMenu"/>
 *         &lt;element name="restaurant_info" type="{http://openmenu.org/schema}RestaurantInfo"/>
 *         &lt;element name="menus">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="menu_item_option" type="{http://openmenu.org/schema}Menu" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="uuid" use="required" type="{http://openmenu.org/schema}Uuid" />
 *       &lt;attribute name="created_date" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="accuracy" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;enumeration value="1"/>
 *             &lt;enumeration value="5"/>
 *             &lt;enumeration value="9"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="private">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="private"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "OpenMenuFormat", propOrder = { "openmenu", "restaurantInfo", "menus" } )
public class OpenMenuFormat
{

    @XmlElement( required = true )
    protected OpenMenu openmenu;

    @XmlElement( name = "restaurant_info", required = true )
    protected RestaurantInfo restaurantInfo;

    @XmlAttribute( name = "uuid", required = true )
    @XmlJavaTypeAdapter( UuidXmlAdapter.class )
    protected UUID uuid;

    @XmlAttribute( name = "created_date", required = true )
    @XmlJavaTypeAdapter( DateTimeXmlAdapter.class )
    @XmlSchemaType( name = "dateTime" )
    protected DateTime createdDate;

    @XmlAttribute( name = "accuracy", required = true )
    protected int accuracy;

    @XmlAttribute( name = "private" )
    protected String _private;

    @XmlElementWrapper( name = "menus", required = true )
    @XmlElement( name = "menu_item_option" )
    protected List<Menu> menus;

    /**
     * Gets the value of the openmenu property.
     * 
     * @return possible object is {@link OpenMenu }
     */
    public OpenMenu getOpenmenu()
    {
        return openmenu;
    }

    /**
     * Sets the value of the openmenu property.
     * 
     * @param value allowed object is {@link OpenMenu }
     */
    public void setOpenmenu( OpenMenu value )
    {
        this.openmenu = value;
    }

    /**
     * Gets the value of the restaurantInfo property.
     * 
     * @return possible object is {@link RestaurantInfo }
     */
    public RestaurantInfo getRestaurantInfo()
    {
        return restaurantInfo;
    }

    /**
     * Sets the value of the restaurantInfo property.
     * 
     * @param value allowed object is {@link RestaurantInfo }
     */
    public void setRestaurantInfo( RestaurantInfo value )
    {
        this.restaurantInfo = value;
    }

    /**
     * Gets the value of the uuid property.
     * 
     * @return possible object is {@link String }
     */
    public UUID getUuid()
    {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setUuid( UUID value )
    {
        this.uuid = value;
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return possible object is {@link String }
     */
    public DateTime getCreatedDate()
    {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setCreatedDate( DateTime value )
    {
        this.createdDate = value;
    }

    /**
     * Gets the value of the accuracy property.
     */
    public int getAccuracy()
    {
        return accuracy;
    }

    /**
     * Sets the value of the accuracy property.
     */
    public void setAccuracy( int value )
    {
        this.accuracy = value;
    }

    /**
     * Gets the value of the private property.
     * 
     * @return possible object is {@link String }
     */
    public String getPrivate()
    {
        return _private;
    }

    /**
     * Sets the value of the private property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setPrivate( String value )
    {
        this._private = value;
    }

    public List<Menu> getMenus()
    {
        if ( menus == null )
        {
            menus = new ArrayList<Menu>();
        }
        return menus;
    }

    public void setMenus( List<Menu> menus )
    {
        this.menus = menus;
    }

}

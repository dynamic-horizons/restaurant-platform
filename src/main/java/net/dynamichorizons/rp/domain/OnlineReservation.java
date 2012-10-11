//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.20 at 06:12:49 PM CDT 
//

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
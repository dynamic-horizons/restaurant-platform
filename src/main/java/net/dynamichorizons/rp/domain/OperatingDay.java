//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.20 at 06:12:49 PM CDT 
//

package net.dynamichorizons.rp.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
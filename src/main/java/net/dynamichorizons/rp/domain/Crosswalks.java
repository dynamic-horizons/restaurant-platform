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
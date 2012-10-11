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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * <p>
 * Java class for ImageType complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImageType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://openmenu.org/schema>UrlType">
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="full"/>
 *             &lt;enumeration value="thumbnail"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="media" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="mobile"/>
 *             &lt;enumeration value="print"/>
 *             &lt;enumeration value="web"/>
 *             &lt;enumeration value="all"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "ImageType", propOrder = { "value" } )
public class ImageType
{

    @XmlValue
    protected String value;

    @XmlAttribute( name = "width" )
    protected Integer width;

    @XmlAttribute( name = "height" )
    protected Integer height;

    @XmlAttribute( name = "type", required = true )
    protected String type;

    @XmlAttribute( name = "media", required = true )
    protected String media;

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
     * Gets the value of the width property.
     * 
     * @return possible object is {@link Integer }
     */
    public Integer getWidth()
    {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value allowed object is {@link Integer }
     */
    public void setWidth( Integer value )
    {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return possible object is {@link Integer }
     */
    public Integer getHeight()
    {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value allowed object is {@link Integer }
     */
    public void setHeight( Integer value )
    {
        this.height = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return possible object is {@link String }
     */
    public String getType()
    {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setType( String value )
    {
        this.type = value;
    }

    /**
     * Gets the value of the media property.
     * 
     * @return possible object is {@link String }
     */
    public String getMedia()
    {
        return media;
    }

    /**
     * Sets the value of the media property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setMedia( String value )
    {
        this.media = value;
    }

}
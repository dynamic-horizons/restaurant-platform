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
package net.dynamichorizons.rp.domain.omf;

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

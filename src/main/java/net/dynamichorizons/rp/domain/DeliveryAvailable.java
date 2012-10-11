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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * <p>
 * Java class for DeliveryAvailable complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliveryAvailable">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>boolean">
 *       &lt;attribute name="radius" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="fee" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "DeliveryAvailable", propOrder = { "value" } )
public class DeliveryAvailable
{

    @XmlValue
    protected boolean value;

    @XmlAttribute( name = "radius" )
    protected Double radius;

    @XmlAttribute( name = "fee" )
    protected Double fee;

    /**
     * Gets the value of the value property.
     */
    public boolean isValue()
    {
        return value;
    }

    /**
     * Sets the value of the value property.
     */
    public void setValue( boolean value )
    {
        this.value = value;
    }

    /**
     * Gets the value of the radius property.
     * 
     * @return possible object is {@link Double }
     */
    public Double getRadius()
    {
        return radius;
    }

    /**
     * Sets the value of the radius property.
     * 
     * @param value allowed object is {@link Double }
     */
    public void setRadius( Double value )
    {
        this.radius = value;
    }

    /**
     * Gets the value of the fee property.
     * 
     * @return possible object is {@link Double }
     */
    public Double getFee()
    {
        return fee;
    }

    /**
     * Sets the value of the fee property.
     * 
     * @param value allowed object is {@link Double }
     */
    public void setFee( Double value )
    {
        this.fee = value;
    }

}

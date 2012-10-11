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

@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Contact", propOrder = { "firstName", "lastName", "email" } )
public class Contact
{

    @XmlElement( name = "first_name", required = true )
    protected String firstName;

    @XmlElement( name = "last_name", required = true )
    protected String lastName;

    @XmlElement( required = true )
    protected String email;

    @XmlAttribute( name = "type" )
    protected String type;

    /**
     * Gets the value of the firstName property.
     * 
     * @return possible object is {@link String }
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setFirstName( String value )
    {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return possible object is {@link String }
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setLastName( String value )
    {
        this.lastName = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return possible object is {@link String }
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setEmail( String value )
    {
        this.email = value;
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

}

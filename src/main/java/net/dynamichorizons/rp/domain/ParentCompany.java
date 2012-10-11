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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ParentCompany complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParentCompany">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parent_company_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parent_company_website" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="address_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="address_2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="city_town" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="state_province" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postal_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="phone" type="{http://openmenu.org/schema}PhoneNumber"/>
 *         &lt;element name="fax" type="{http://openmenu.org/schema}PhoneNumber"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "ParentCompany", propOrder = { "parentCompanyName",
    "parentCompanyWebsite",
    "address1",
    "address2",
    "cityTown",
    "stateProvince",
    "postalCode",
    "country",
    "phone",
    "fax" } )
public class ParentCompany
{

    @XmlElement( name = "parent_company_name", required = true )
    protected String parentCompanyName;

    @XmlElement( name = "parent_company_website", required = true )
    protected String parentCompanyWebsite;

    @XmlElement( name = "address_1", required = true )
    protected String address1;

    @XmlElement( name = "address_2", required = true )
    protected String address2;

    @XmlElement( name = "city_town", required = true )
    protected String cityTown;

    @XmlElement( name = "state_province", required = true )
    protected String stateProvince;

    @XmlElement( name = "postal_code", required = true )
    protected String postalCode;

    @XmlElement( required = true )
    protected String country;

    @XmlElement( required = true )
    protected String phone;

    @XmlElement( required = true )
    protected String fax;

    /**
     * Gets the value of the parentCompanyName property.
     * 
     * @return possible object is {@link String }
     */
    public String getParentCompanyName()
    {
        return parentCompanyName;
    }

    /**
     * Sets the value of the parentCompanyName property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setParentCompanyName( String value )
    {
        this.parentCompanyName = value;
    }

    /**
     * Gets the value of the parentCompanyWebsite property.
     * 
     * @return possible object is {@link String }
     */
    public String getParentCompanyWebsite()
    {
        return parentCompanyWebsite;
    }

    /**
     * Sets the value of the parentCompanyWebsite property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setParentCompanyWebsite( String value )
    {
        this.parentCompanyWebsite = value;
    }

    /**
     * Gets the value of the address1 property.
     * 
     * @return possible object is {@link String }
     */
    public String getAddress1()
    {
        return address1;
    }

    /**
     * Sets the value of the address1 property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setAddress1( String value )
    {
        this.address1 = value;
    }

    /**
     * Gets the value of the address2 property.
     * 
     * @return possible object is {@link String }
     */
    public String getAddress2()
    {
        return address2;
    }

    /**
     * Sets the value of the address2 property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setAddress2( String value )
    {
        this.address2 = value;
    }

    /**
     * Gets the value of the cityTown property.
     * 
     * @return possible object is {@link String }
     */
    public String getCityTown()
    {
        return cityTown;
    }

    /**
     * Sets the value of the cityTown property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setCityTown( String value )
    {
        this.cityTown = value;
    }

    /**
     * Gets the value of the stateProvince property.
     * 
     * @return possible object is {@link String }
     */
    public String getStateProvince()
    {
        return stateProvince;
    }

    /**
     * Sets the value of the stateProvince property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setStateProvince( String value )
    {
        this.stateProvince = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return possible object is {@link String }
     */
    public String getPostalCode()
    {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setPostalCode( String value )
    {
        this.postalCode = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return possible object is {@link String }
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setCountry( String value )
    {
        this.country = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return possible object is {@link String }
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setPhone( String value )
    {
        this.phone = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return possible object is {@link String }
     */
    public String getFax()
    {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setFax( String value )
    {
        this.fax = value;
    }

}

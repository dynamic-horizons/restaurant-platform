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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for RestaurantInfo complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RestaurantInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="restaurant_name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="2"/>
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="business_type">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Franchisee"/>
 *               &lt;enumeration value="Corporate"/>
 *               &lt;enumeration value="Independent"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="brief_description">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="2"/>
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="full_description" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="2000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="location_id" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="25"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="mobile" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="utc_offset" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="address_1">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="2"/>
 *               &lt;maxLength value="120"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="address_2" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="120"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="city_town">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="2"/>
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="region_area" type="{http://openmenu.org/schema}Region" minOccurs="0"/>
 *         &lt;element name="state_province" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="postal_code" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="country">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="phone" type="{http://openmenu.org/schema}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="fax" type="{http://openmenu.org/schema}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="website_url" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="120"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="omf_file_url">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="120"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="logo_urls">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="logo_url" type="{http://openmenu.org/schema}ImageType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="environment" type="{http://openmenu.org/schema}Environment"/>
 *         &lt;element name="contacts" type="{http://openmenu.org/schema}Contacts"/>
 *         &lt;element name="parent_company" type="{http://openmenu.org/schema}ParentCompany"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "RestaurantInfo", propOrder = { "restaurantName",
    "businessType",
    "briefDescription",
    "fullDescription",
    "locationId",
    "mobile",
    "longitude",
    "latitude",
    "utcOffset",
    "address1",
    "address2",
    "cityTown",
    "regionArea",
    "stateProvince",
    "postalCode",
    "country",
    "phone",
    "fax",
    "websiteUrl",
    "omfFileUrl",
    "logoUrls",
    "environment",
    "contacts",
    "parentCompany" } )
public class RestaurantInfo
{

    @XmlElement( name = "restaurant_name", required = true )
    protected String restaurantName;

    @XmlElement( name = "business_type", required = true )
    protected String businessType;

    @XmlElement( name = "brief_description", required = true )
    protected String briefDescription;

    @XmlElement( name = "full_description" )
    protected String fullDescription;

    @XmlElement( name = "location_id" )
    protected String locationId;

    protected Integer mobile;

    protected BigDecimal longitude;

    protected BigDecimal latitude;

    @XmlElement( name = "utc_offset" )
    protected BigDecimal utcOffset;

    @XmlElement( name = "address_1", required = true )
    protected String address1;

    @XmlElement( name = "address_2" )
    protected String address2;

    @XmlElement( name = "city_town", required = true )
    protected String cityTown;

    @XmlElement( name = "region_area" )
    protected Region regionArea;

    @XmlElement( name = "state_province" )
    protected String stateProvince;

    @XmlElement( name = "postal_code" )
    protected String postalCode;

    @XmlElement( required = true )
    protected String country;

    protected String phone;

    protected String fax;

    @XmlElement( name = "website_url" )
    protected String websiteUrl;

    @XmlElement( name = "omf_file_url", required = true )
    protected String omfFileUrl;

    @XmlElement( required = true )
    protected Environment environment;

    @XmlElement( required = true )
    protected Contacts contacts;

    @XmlElement( name = "parent_company", required = true )
    protected ParentCompany parentCompany;

    @XmlElementWrapper( name = "logo_urls", required = true )
    @XmlElement( name = "logo_url" )
    protected List<ImageType> logoUrls;

    /**
     * Gets the value of the restaurantName property.
     * 
     * @return possible object is {@link String }
     */
    public String getRestaurantName()
    {
        return restaurantName;
    }

    /**
     * Sets the value of the restaurantName property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setRestaurantName( String value )
    {
        this.restaurantName = value;
    }

    /**
     * Gets the value of the businessType property.
     * 
     * @return possible object is {@link String }
     */
    public String getBusinessType()
    {
        return businessType;
    }

    /**
     * Sets the value of the businessType property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setBusinessType( String value )
    {
        this.businessType = value;
    }

    /**
     * Gets the value of the briefDescription property.
     * 
     * @return possible object is {@link String }
     */
    public String getBriefDescription()
    {
        return briefDescription;
    }

    /**
     * Sets the value of the briefDescription property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setBriefDescription( String value )
    {
        this.briefDescription = value;
    }

    /**
     * Gets the value of the fullDescription property.
     * 
     * @return possible object is {@link String }
     */
    public String getFullDescription()
    {
        return fullDescription;
    }

    /**
     * Sets the value of the fullDescription property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setFullDescription( String value )
    {
        this.fullDescription = value;
    }

    /**
     * Gets the value of the locationId property.
     * 
     * @return possible object is {@link String }
     */
    public String getLocationId()
    {
        return locationId;
    }

    /**
     * Sets the value of the locationId property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setLocationId( String value )
    {
        this.locationId = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return possible object is {@link Integer }
     */
    public Integer getMobile()
    {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value allowed object is {@link Integer }
     */
    public void setMobile( Integer value )
    {
        this.mobile = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getLongitude()
    {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value allowed object is {@link BigDecimal }
     */
    public void setLongitude( BigDecimal value )
    {
        this.longitude = value;
    }

    /**
     * Gets the value of the latitude property.
     * 
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getLatitude()
    {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value allowed object is {@link BigDecimal }
     */
    public void setLatitude( BigDecimal value )
    {
        this.latitude = value;
    }

    /**
     * Gets the value of the utcOffset property.
     * 
     * @return possible object is {@link BigDecimal }
     */
    public BigDecimal getUtcOffset()
    {
        return utcOffset;
    }

    /**
     * Sets the value of the utcOffset property.
     * 
     * @param value allowed object is {@link BigDecimal }
     */
    public void setUtcOffset( BigDecimal value )
    {
        this.utcOffset = value;
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
     * Gets the value of the regionArea property.
     * 
     * @return possible object is {@link Region }
     */
    public Region getRegionArea()
    {
        return regionArea;
    }

    /**
     * Sets the value of the regionArea property.
     * 
     * @param value allowed object is {@link Region }
     */
    public void setRegionArea( Region value )
    {
        this.regionArea = value;
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

    /**
     * Gets the value of the websiteUrl property.
     * 
     * @return possible object is {@link String }
     */
    public String getWebsiteUrl()
    {
        return websiteUrl;
    }

    /**
     * Sets the value of the websiteUrl property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setWebsiteUrl( String value )
    {
        this.websiteUrl = value;
    }

    /**
     * Gets the value of the omfFileUrl property.
     * 
     * @return possible object is {@link String }
     */
    public String getOmfFileUrl()
    {
        return omfFileUrl;
    }

    /**
     * Sets the value of the omfFileUrl property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setOmfFileUrl( String value )
    {
        this.omfFileUrl = value;
    }

    /**
     * Gets the value of the environment property.
     * 
     * @return possible object is {@link Environment }
     */
    public Environment getEnvironment()
    {
        return environment;
    }

    /**
     * Sets the value of the environment property.
     * 
     * @param value allowed object is {@link Environment }
     */
    public void setEnvironment( Environment value )
    {
        this.environment = value;
    }

    /**
     * Gets the value of the contacts property.
     * 
     * @return possible object is {@link Contacts }
     */
    public Contacts getContacts()
    {
        return contacts;
    }

    /**
     * Sets the value of the contacts property.
     * 
     * @param value allowed object is {@link Contacts }
     */
    public void setContacts( Contacts value )
    {
        this.contacts = value;
    }

    /**
     * Gets the value of the parentCompany property.
     * 
     * @return possible object is {@link ParentCompany }
     */
    public ParentCompany getParentCompany()
    {
        return parentCompany;
    }

    /**
     * Sets the value of the parentCompany property.
     * 
     * @param value allowed object is {@link ParentCompany }
     */
    public void setParentCompany( ParentCompany value )
    {
        this.parentCompany = value;
    }

    public List<ImageType> getLogoUrls()
    {
        if ( logoUrls == null )
        {
            logoUrls = new ArrayList<ImageType>();
        }
        return logoUrls;
    }

    public void setLogoUrls( List<ImageType> logoUrls )
    {
        this.logoUrls = logoUrls;
    }

}

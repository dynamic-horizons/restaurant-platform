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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Environment complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Environment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="seating_qty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="max_group_size" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="age_level_preference" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="smoking_allowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="takeout_available" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="delivery_available" type="{http://openmenu.org/schema}DeliveryAvailable" minOccurs="0"/>
 *         &lt;element name="catering_available" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="reservations" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="no"/>
 *               &lt;enumeration value="suggested"/>
 *               &lt;enumeration value="required"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="alcohol_type" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="full bar"/>
 *               &lt;enumeration value="beer and wine"/>
 *               &lt;enumeration value="wine only"/>
 *               &lt;enumeration value="beer only"/>
 *               &lt;enumeration value="none"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="music_type" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="none"/>
 *               &lt;enumeration value="live"/>
 *               &lt;enumeration value="pre-recorded"/>
 *               &lt;enumeration value="dj"/>
 *               &lt;enumeration value="jukebox"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="pets_allowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="wheelchair_accessible" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dress_code" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="cuisine_type_primary" type="{http://openmenu.org/schema}Cuisine"/>
 *         &lt;element name="cuisine_type_secondary" type="{http://openmenu.org/schema}Cuisine" minOccurs="0"/>
 *         &lt;element name="seating_locations" type="{http://openmenu.org/schema}SeatingLocations"/>
 *         &lt;element name="accepted_currencies" type="{http://openmenu.org/schema}AcceptedCurrencies"/>
 *         &lt;element name="online_reservations">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="online_reservation" type="{http://openmenu.org/schema}OnlineReservation" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="online_ordering">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="online_reservation" type="{http://openmenu.org/schema}OnlineReservation" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="operating_days">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="operating_day" type="{http://openmenu.org/schema}OperatingDay" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="parking" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Environment", propOrder = { "seatingQty",
    "maxGroupSize",
    "ageLevelPreference",
    "smokingAllowed",
    "takeoutAvailable",
    "deliveryAvailable",
    "cateringAvailable",
    "reservations",
    "alcoholType",
    "musicType",
    "petsAllowed",
    "wheelchairAccessible",
    "dressCode",
    "cuisineTypePrimary",
    "cuisineTypeSecondary",
    "seatingLocations",
    "acceptedCurrencies",
    "onlineReservations",
    "onlineOrdering",
    "operatingDays",
    "parking" } )
public class Environment
{

    @XmlElement( name = "seating_qty" )
    protected Integer seatingQty;

    @XmlElement( name = "max_group_size" )
    protected Integer maxGroupSize;

    @XmlElement( name = "age_level_preference" )
    protected Integer ageLevelPreference;

    @XmlElement( name = "smoking_allowed" )
    protected Boolean smokingAllowed;

    @XmlElement( name = "takeout_available" )
    protected Boolean takeoutAvailable;

    @XmlElement( name = "delivery_available" )
    protected DeliveryAvailable deliveryAvailable;

    @XmlElement( name = "catering_available" )
    protected Boolean cateringAvailable;

    protected String reservations;

    @XmlElement( name = "alcohol_type" )
    protected String alcoholType;

    @XmlElement( name = "music_type" )
    protected String musicType;

    @XmlElement( name = "pets_allowed" )
    protected Boolean petsAllowed;

    @XmlElement( name = "wheelchair_accessible" )
    protected Boolean wheelchairAccessible;

    @XmlElement( name = "dress_code" )
    protected Boolean dressCode;

    @XmlElement( name = "cuisine_type_primary", required = true )
    protected Cuisine cuisineTypePrimary;

    @XmlElement( name = "cuisine_type_secondary" )
    protected Cuisine cuisineTypeSecondary;

    @XmlElement( required = true )
    protected String parking;

    @XmlElementWrapper( name = "seating_locations", required = true )
    @XmlElement( name = "seating_location" )
    protected List<String> seatingLocations;

    @XmlElementWrapper( name = "accepted_currencies", required = true )
    @XmlElement( name = "accepted_currency" )
    protected List<String> acceptedCurrencies;

    @XmlElementWrapper( name = "online_reservations", required = true )
    @XmlElement( name = "online_reservation" )
    protected List<OnlineReservation> onlineReservations;

    @XmlElementWrapper( name = "online_ordering", required = true )
    @XmlElement( name = "online_reservation" )
    protected List<OnlineReservation> onlineOrdering;

    @XmlElementWrapper( name = "operating_days", required = true )
    @XmlElement( name = "operating_day" )
    protected List<OperatingDay> operatingDays;

    /**
     * Gets the value of the seatingQty property.
     * 
     * @return possible object is {@link Integer }
     */
    public Integer getSeatingQty()
    {
        return seatingQty;
    }

    /**
     * Sets the value of the seatingQty property.
     * 
     * @param value allowed object is {@link Integer }
     */
    public void setSeatingQty( Integer value )
    {
        this.seatingQty = value;
    }

    /**
     * Gets the value of the maxGroupSize property.
     * 
     * @return possible object is {@link Integer }
     */
    public Integer getMaxGroupSize()
    {
        return maxGroupSize;
    }

    /**
     * Sets the value of the maxGroupSize property.
     * 
     * @param value allowed object is {@link Integer }
     */
    public void setMaxGroupSize( Integer value )
    {
        this.maxGroupSize = value;
    }

    /**
     * Gets the value of the ageLevelPreference property.
     * 
     * @return possible object is {@link Integer }
     */
    public Integer getAgeLevelPreference()
    {
        return ageLevelPreference;
    }

    /**
     * Sets the value of the ageLevelPreference property.
     * 
     * @param value allowed object is {@link Integer }
     */
    public void setAgeLevelPreference( Integer value )
    {
        this.ageLevelPreference = value;
    }

    /**
     * Gets the value of the smokingAllowed property.
     * 
     * @return possible object is {@link Boolean }
     */
    public Boolean isSmokingAllowed()
    {
        return smokingAllowed;
    }

    /**
     * Sets the value of the smokingAllowed property.
     * 
     * @param value allowed object is {@link Boolean }
     */
    public void setSmokingAllowed( Boolean value )
    {
        this.smokingAllowed = value;
    }

    /**
     * Gets the value of the takeoutAvailable property.
     * 
     * @return possible object is {@link Boolean }
     */
    public Boolean isTakeoutAvailable()
    {
        return takeoutAvailable;
    }

    /**
     * Sets the value of the takeoutAvailable property.
     * 
     * @param value allowed object is {@link Boolean }
     */
    public void setTakeoutAvailable( Boolean value )
    {
        this.takeoutAvailable = value;
    }

    /**
     * Gets the value of the deliveryAvailable property.
     * 
     * @return possible object is {@link DeliveryAvailable }
     */
    public DeliveryAvailable getDeliveryAvailable()
    {
        return deliveryAvailable;
    }

    /**
     * Sets the value of the deliveryAvailable property.
     * 
     * @param value allowed object is {@link DeliveryAvailable }
     */
    public void setDeliveryAvailable( DeliveryAvailable value )
    {
        this.deliveryAvailable = value;
    }

    /**
     * Gets the value of the cateringAvailable property.
     * 
     * @return possible object is {@link Boolean }
     */
    public Boolean isCateringAvailable()
    {
        return cateringAvailable;
    }

    /**
     * Sets the value of the cateringAvailable property.
     * 
     * @param value allowed object is {@link Boolean }
     */
    public void setCateringAvailable( Boolean value )
    {
        this.cateringAvailable = value;
    }

    /**
     * Gets the value of the reservations property.
     * 
     * @return possible object is {@link String }
     */
    public String getReservations()
    {
        return reservations;
    }

    /**
     * Sets the value of the reservations property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setReservations( String value )
    {
        this.reservations = value;
    }

    /**
     * Gets the value of the alcoholType property.
     * 
     * @return possible object is {@link String }
     */
    public String getAlcoholType()
    {
        return alcoholType;
    }

    /**
     * Sets the value of the alcoholType property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setAlcoholType( String value )
    {
        this.alcoholType = value;
    }

    /**
     * Gets the value of the musicType property.
     * 
     * @return possible object is {@link String }
     */
    public String getMusicType()
    {
        return musicType;
    }

    /**
     * Sets the value of the musicType property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setMusicType( String value )
    {
        this.musicType = value;
    }

    /**
     * Gets the value of the petsAllowed property.
     * 
     * @return possible object is {@link Boolean }
     */
    public Boolean isPetsAllowed()
    {
        return petsAllowed;
    }

    /**
     * Sets the value of the petsAllowed property.
     * 
     * @param value allowed object is {@link Boolean }
     */
    public void setPetsAllowed( Boolean value )
    {
        this.petsAllowed = value;
    }

    /**
     * Gets the value of the wheelchairAccessible property.
     * 
     * @return possible object is {@link Boolean }
     */
    public Boolean isWheelchairAccessible()
    {
        return wheelchairAccessible;
    }

    /**
     * Sets the value of the wheelchairAccessible property.
     * 
     * @param value allowed object is {@link Boolean }
     */
    public void setWheelchairAccessible( Boolean value )
    {
        this.wheelchairAccessible = value;
    }

    /**
     * Gets the value of the dressCode property.
     * 
     * @return possible object is {@link Boolean }
     */
    public Boolean isDressCode()
    {
        return dressCode;
    }

    /**
     * Sets the value of the dressCode property.
     * 
     * @param value allowed object is {@link Boolean }
     */
    public void setDressCode( Boolean value )
    {
        this.dressCode = value;
    }

    /**
     * Gets the value of the cuisineTypePrimary property.
     * 
     * @return possible object is {@link Cuisine }
     */
    public Cuisine getCuisineTypePrimary()
    {
        return cuisineTypePrimary;
    }

    /**
     * Sets the value of the cuisineTypePrimary property.
     * 
     * @param value allowed object is {@link Cuisine }
     */
    public void setCuisineTypePrimary( Cuisine value )
    {
        this.cuisineTypePrimary = value;
    }

    /**
     * Gets the value of the cuisineTypeSecondary property.
     * 
     * @return possible object is {@link Cuisine }
     */
    public Cuisine getCuisineTypeSecondary()
    {
        return cuisineTypeSecondary;
    }

    /**
     * Sets the value of the cuisineTypeSecondary property.
     * 
     * @param value allowed object is {@link Cuisine }
     */
    public void setCuisineTypeSecondary( Cuisine value )
    {
        this.cuisineTypeSecondary = value;
    }

    /**
     * Gets the value of the parking property.
     * 
     * @return possible object is {@link String }
     */
    public String getParking()
    {
        return parking;
    }

    /**
     * Sets the value of the parking property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setParking( String value )
    {
        this.parking = value;
    }

    public List<String> getSeatingLocations()
    {
        if ( seatingLocations == null )
        {
            seatingLocations = new ArrayList<String>();
        }
        return seatingLocations;
    }

    public void setSeatingLocations( List<String> seatingLocations )
    {
        this.seatingLocations = seatingLocations;
    }

    public List<String> getAcceptedCurrencies()
    {
        if ( acceptedCurrencies == null )
        {
            acceptedCurrencies = new ArrayList<String>();
        }
        return acceptedCurrencies;
    }

    public void setAcceptedCurrencies( List<String> acceptedCurrencies )
    {
        this.acceptedCurrencies = acceptedCurrencies;
    }

    public List<OnlineReservation> getOnlineReservations()
    {
        if ( onlineReservations == null )
        {
            onlineReservations = new ArrayList<OnlineReservation>();
        }
        return onlineReservations;
    }

    public void setOnlineReservations( List<OnlineReservation> onlineReservations )
    {
        this.onlineReservations = onlineReservations;
    }

    public List<OnlineReservation> getOnlineOrdering()
    {
        if ( onlineOrdering == null )
        {
            onlineOrdering = new ArrayList<OnlineReservation>();
        }
        return onlineOrdering;
    }

    public void setOnlineOrdering( List<OnlineReservation> onlineOrdering )
    {
        this.onlineOrdering = onlineOrdering;
    }

    public List<OperatingDay> getOperatingDays()
    {
        if ( operatingDays == null )
        {
            operatingDays = new ArrayList<OperatingDay>();
        }
        return operatingDays;
    }

    public void setOperatingDays( List<OperatingDay> operatingDays )
    {
        this.operatingDays = operatingDays;
    }

}

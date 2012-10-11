package net.dynamichorizons.rp.domain.menu;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "", propOrder = { "value" } )
@Embeddable
public class MenuItemAllergyInformation
{

    @XmlValue
    @Column( name = "MENU_ITEM_ALLERGY_INFORMATION", nullable = true, length = 450 )
    protected String value;

    @XmlAttribute( name = "allergens" )
    @Column( name = "MENU_ITEM_ALLERGENS", nullable = true, length = 255 )
    protected String allergens;

    public MenuItemAllergyInformation()
    {
    }

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
     * Gets the value of the allergens property.
     * 
     * @return possible object is {@link String }
     */
    public String getAllergens()
    {
        return allergens;
    }

    /**
     * Sets the value of the allergens property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setAllergens( String value )
    {
        this.allergens = value;
    }
}

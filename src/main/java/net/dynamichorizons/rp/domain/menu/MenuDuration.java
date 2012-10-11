//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.20 at 06:12:49 PM CDT 
//

package net.dynamichorizons.rp.domain.menu;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.dynamichorizons.rp.domain.LocalTimeXmlAdapter;

import org.hibernate.annotations.Type;
import org.joda.time.LocalTime;

@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "MenuDuration", propOrder = { "menuDurationName", "menuDurationTimeStart", "menuDurationTimeEnd" } )
@Embeddable
public class MenuDuration
{

    @XmlElement( name = "menu_duration_name", required = true )
    @Column( name = "MENU_DURATION_NAME", nullable = false )
    protected String menuDurationName;

    @XmlElement( name = "menu_duration_time_start", type = String.class )
    @XmlJavaTypeAdapter( LocalTimeXmlAdapter.class )
    @XmlSchemaType( name = "time" )
    @Type( type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime" )
    @Column( name = "MENU_DURATION_START_TIME", nullable = true )
    protected LocalTime menuDurationTimeStart;

    @XmlElement( name = "menu_duration_time_end", type = String.class )
    @XmlJavaTypeAdapter( LocalTimeXmlAdapter.class )
    @XmlSchemaType( name = "time" )
    @Type( type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime" )
    @Column( name = "MENU_DURATION_END_TIME", nullable = true )
    protected LocalTime menuDurationTimeEnd;

    public MenuDuration()
    {
    }

    /**
     * Gets the value of the menuDurationName property.
     * 
     * @return possible object is {@link String }
     */
    public String getMenuDurationName()
    {
        return menuDurationName;
    }

    /**
     * Sets the value of the menuDurationName property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setMenuDurationName( String value )
    {
        this.menuDurationName = value;
    }

    /**
     * Gets the value of the menuDurationTimeStart property.
     * 
     * @return possible object is {@link String }
     */
    public LocalTime getMenuDurationTimeStart()
    {
        return menuDurationTimeStart;
    }

    /**
     * Sets the value of the menuDurationTimeStart property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setMenuDurationTimeStart( LocalTime value )
    {
        this.menuDurationTimeStart = value;
    }

    /**
     * Gets the value of the menuDurationTimeEnd property.
     * 
     * @return possible object is {@link String }
     */
    public LocalTime getMenuDurationTimeEnd()
    {
        return menuDurationTimeEnd;
    }

    /**
     * Sets the value of the menuDurationTimeEnd property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setMenuDurationTimeEnd( LocalTime value )
    {
        this.menuDurationTimeEnd = value;
    }

}
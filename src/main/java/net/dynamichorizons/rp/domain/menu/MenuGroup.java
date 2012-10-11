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
package net.dynamichorizons.rp.domain.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.dynamichorizons.rp.domain.UuidXmlAdapter;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@XmlRootElement( name = "menu_group" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "MenuGroup", propOrder = { "menuGroupDescription", "menuGroupNote", "menuItems", "menuGroupOptions" } )
@Entity
@Table( name = "TBL_MENU_GROUP" )
public class MenuGroup
    implements Serializable
{

    private static final long serialVersionUID = -229485181478103996L;

    @Id
    @XmlAttribute( name = "uid", required = true )
    @XmlJavaTypeAdapter( UuidXmlAdapter.class )
    @GeneratedValue( generator = "uuid" )
    @GenericGenerator( name = "uuid", strategy = "uuid2" )
    @Column( name = "MENU_GROUP_UID", unique = true, columnDefinition = "BINARY(16)" )
    @Type( type = "uuid-char" )
    protected UUID uid;

    @XmlTransient
    @Version
    @Column( name = "OPTLOCK" )
    protected Integer version;

    @XmlTransient
    @ManyToOne
    @JoinColumn( name = "MENU_UID" )
    protected Menu parentMenu;

    @XmlAttribute( name = "group_name", required = true )
    @Column( name = "MENU_GROUP_NAME", nullable = false, length = 50 )
    protected String name;

    @XmlElement( name = "group_description" )
    @Column( name = "MENU_GROUP_DESC", nullable = true, length = 255 )
    protected String menuGroupDescription;

    @XmlElement( name = "group_note" )
    @Column( name = "MENU_GROUP_NOTE", nullable = true, length = 255 )
    protected String menuGroupNote;

    @XmlAttribute( name = "disabled" )
    @Column( name = "IS_DISABLED", nullable = true )
    protected Boolean disabled;
    
    @XmlTransient                
    @Column( name="ORDER_BY")
    protected Integer orderBy;

    @XmlElementWrapper(name = "menu_items", required = true)
    @XmlElement( name = "menu_item", required = true )
    @Transient
    protected List<MenuItem> menuItems;

    @XmlElementWrapper(name = "menu_group_options", required = true)
    @XmlElement( name = "menu_group_options" )
    @OneToMany( fetch = FetchType.EAGER )
    @JoinColumn( name = "MENU_GROUP_UID" )
    @Fetch( value = FetchMode.SELECT )
    protected List<MenuGroupOption> menuGroupOptions;

    public MenuGroup()
    {
    }

    public UUID getUid()
    {
        return uid;
    }

    public void setUid( UUID uid )
    {
        this.uid = uid;
    }

    public Menu getParentMenu()
    {
        return parentMenu;
    }

    public void setParentMenu( Menu parentMenu )
    {
        this.parentMenu = parentMenu;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getMenuGroupDescription()
    {
        return menuGroupDescription;
    }

    public void setMenuGroupDescription( String menuGroupDescription )
    {
        this.menuGroupDescription = menuGroupDescription;
    }

    public String getMenuGroupNote()
    {
        return menuGroupNote;
    }

    public void setMenuGroupNote( String menuGroupNote )
    {
        this.menuGroupNote = menuGroupNote;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled( Boolean disabled )
    {
        this.disabled = disabled;
    }

    public Integer getOrderBy()
    {
        return orderBy;
    }

    public void setOrderBy( Integer orderBy )
    {
        this.orderBy = orderBy;
    }

    public List<MenuItem> getMenuItems()
    {
        if ( menuItems == null )
        {
            menuItems = new ArrayList<MenuItem>();
        }
        return menuItems;
    }

    public void setMenuItems( List<MenuItem> menuItems )
    {
        this.menuItems = menuItems;
    }

    public List<MenuGroupOption> getMenuGroupOptions()
    {
        if ( menuGroupOptions == null )
        {
            menuGroupOptions = new ArrayList<MenuGroupOption>();
        }
        return menuGroupOptions;
    }

    public void setMenuGroupOptions( List<MenuGroupOption> menuGroupOptions )
    {
        this.menuGroupOptions = menuGroupOptions;
    }

    public String toString()
    {
        return new ToStringBuilder( this ).append( "uid", uid ).append( "name", name ).append( "menuItems",
                                                                                               getMenuItems() ).toString();
    }
}

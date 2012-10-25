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

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

@XmlRootElement( name = "menu_item_image" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "MenuItemImage" )
@Entity
@Table( name = "TBL_MENU_ITEM_IMAGE" )
@AttributeOverride( name = "id", column = @Column( name = "MENU_ITEM_IMAGE_ID" ) )
public class MenuItemImage
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = 9089663846396980114L;

    @XmlTransient
    @Column( name = "MENU_GROUP_ITEM_ID" )
    protected Long menuGroupItemId;

    @XmlAttribute( name = "width" )
    @Column( name = "MENU_ITEM_IMAGE_WIDTH", nullable = true )
    protected String width;

    @XmlAttribute( name = "height" )
    @Column( name = "MENU_ITEM_IMAGE_HEIGHT", nullable = true )
    protected String height;

    @XmlAttribute( name = "type" )
    @Column( name = "MENU_ITEM_IMAGE_TYPE", nullable = false )
    protected String type;

    @XmlAttribute( name = "media" )
    @Column( name = "MENU_ITEM_IMAGE_MEDIA", nullable = false )
    protected String media;

    public MenuItemImage()
    {
    }

    public Long getMenuGroupItemId()
    {
        return menuGroupItemId;
    }

    public void setMenuGroupItemId( Long menuGroupItemId )
    {
        this.menuGroupItemId = menuGroupItemId;
    }

    public String getWidth()
    {
        return width;
    }

    public void setWidth( String width )
    {
        this.width = width;
    }

    public String getHeight()
    {
        return height;
    }

    public void setHeight( String height )
    {
        this.height = height;
    }

    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public String getMedia()
    {
        return media;
    }

    public void setMedia( String media )
    {
        this.media = media;
    }

}

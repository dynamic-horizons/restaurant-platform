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

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;
import org.joda.time.LocalTime;

@Embeddable
public class MenuDuration
{

    @Column( name = "MENU_DURATION_NAME", nullable = false )
    protected String menuDurationName;

    @Type( type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime" )
    @Column( name = "MENU_DURATION_START_TIME", nullable = true )
    protected LocalTime menuDurationTimeStart;

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

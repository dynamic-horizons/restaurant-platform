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
package net.dynamichorizons.rp.domain.omf;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for OnlineType.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="OnlineType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="web"/>
 *     &lt;enumeration value="mobile"/>
 *     &lt;enumeration value="web/mobile"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType( name = "OnlineType" )
@XmlEnum
public enum OnlineType
{

    @XmlEnumValue( "web" )
    WEB( "web" ), @XmlEnumValue( "mobile" )
    MOBILE( "mobile" ), @XmlEnumValue( "web/mobile" )
    WEB_MOBILE( "web/mobile" );
    private final String value;

    OnlineType( String v )
    {
        value = v;
    }

    public String value()
    {
        return value;
    }

    public static OnlineType fromValue( String v )
    {
        for ( OnlineType c : OnlineType.values() )
        {
            if ( c.value.equals( v ) )
            {
                return c;
            }
        }
        throw new IllegalArgumentException( v );
    }

}

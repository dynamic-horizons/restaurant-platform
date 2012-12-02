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
package net.dynamichorizons.rp.util;

import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class DatatypeConverter
{

    public static UUID parseUuid( String xmlValue )
    {
        return UUID.fromString( xmlValue );
    }

    public static String printUuid( UUID value )
    {
        return value.toString();
    }

    public static DateTime parseDateTime( String s )
    {
        return new DateTime( s );
    }

    public static String printDateTime( DateTime dt )
    {
        return dt.toString();
    }

    public static LocalDate parseDate( String s )
    {
        return new LocalDate( s );
    }

    public static String printDate( LocalDate ld )
    {
        return ld.toString();
    }

    public static LocalTime parseTime( String s )
    {
        return new LocalTime( s );
    }

    public static String printTime( LocalTime lt )
    {
        return lt.toString();
    }
}

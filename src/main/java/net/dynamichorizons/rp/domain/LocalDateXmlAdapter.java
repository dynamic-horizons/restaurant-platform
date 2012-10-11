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

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.LocalDate;

public class LocalDateXmlAdapter
    extends XmlAdapter<String, LocalDate>
{

    public LocalDate unmarshal( String value )
    {
        return ( net.dynamichorizons.rp.util.DatatypeConverter.parseDate( value ) );
    }

    public String marshal( LocalDate value )
    {
        return ( net.dynamichorizons.rp.util.DatatypeConverter.printDate( value ) );
    }

}

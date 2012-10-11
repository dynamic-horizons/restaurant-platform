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

import java.util.UUID;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UuidXmlAdapter
    extends XmlAdapter<String, UUID>
{

    public UUID unmarshal( String value )
    {
        return ( net.dynamichorizons.rp.util.DatatypeConverter.parseUuid( value ) );
    }

    public String marshal( UUID value )
    {
        return ( net.dynamichorizons.rp.util.DatatypeConverter.printUuid( value ) );
    }

}

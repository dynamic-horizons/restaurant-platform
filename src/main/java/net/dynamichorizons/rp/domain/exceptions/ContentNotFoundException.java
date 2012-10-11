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
package net.dynamichorizons.rp.domain.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ContentNotFoundException
    extends WebApplicationException
{

    private static final long serialVersionUID = -6275589246975420266L;

    public ContentNotFoundException()
    {
        super( Response.Status.NOT_FOUND );
    }

    public ContentNotFoundException( Throwable exception )
    {
        super( exception, Response.Status.NOT_FOUND );
    }

}

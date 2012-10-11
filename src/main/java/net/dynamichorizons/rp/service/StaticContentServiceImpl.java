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
package net.dynamichorizons.rp.service;

import java.io.IOException;

import net.dynamichorizons.rp.domain.exceptions.StaticContentException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StaticContentServiceImpl
    implements StaticContentService
{

    Logger logger = LoggerFactory.getLogger( StaticContentServiceImpl.class );

    @Override
    public String getStaticContentPage( String pageName )
    {
        return "<h1>Test Static Content Page</h1>";
    }

    @Override
    public String getTemplate( String templateName )
        throws StaticContentException
    {
        try
        {
            return IOUtils.toString( getClass().getResourceAsStream( "/templates/" + templateName.replace( ".", "/" )
                                                                         + ".tpl" ) );
        }
        catch ( IOException e )
        {
            throw new StaticContentException();
        }
    }
}

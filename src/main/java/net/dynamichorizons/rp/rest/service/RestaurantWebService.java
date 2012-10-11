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
package net.dynamichorizons.rp.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.dynamichorizons.rp.domain.Restaurant;
import net.dynamichorizons.rp.domain.exceptions.ContentNotFoundException;
import net.dynamichorizons.rp.domain.exceptions.StaticContentException;
import net.dynamichorizons.rp.service.StaticContentService;
import net.dynamichorizons.rp.stereotype.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService
@Path( "/" )
public class RestaurantWebService
{

    @Autowired
    private StaticContentService staticContentService;

    @GET
    @Produces( MediaType.TEXT_PLAIN )
    public String defaultService()
    {
        return "Brothers Deli REST Service";
    }

    @GET
    @Path( "/build" )
    @Produces( MediaType.TEXT_PLAIN )
    public String buildInformation()
    {
        return "Brothers Deli - V1.0";
    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Restaurant getRestaurant()
    {
        return null;
    }

    @GET
    @Path( "/static/{pageName}" )
    @Produces( MediaType.TEXT_HTML )
    public String getStaticContent( @PathParam( "pageName" )
    String pageName )
    {
        try
        {
            return staticContentService.getStaticContentPage( pageName );
        }
        catch ( StaticContentException e )
        {
            throw new ContentNotFoundException( e );
        }
    }

    @GET
    @Path( "/tpl/{templateName}" )
    @Produces( MediaType.TEXT_HTML )
    public String getTemplate( @PathParam( "templateName" )
    String templateName )
    {
        try
        {
            return staticContentService.getTemplate( templateName );
        }
        catch ( StaticContentException e )
        {
            throw new ContentNotFoundException( e );
        }
    }
}

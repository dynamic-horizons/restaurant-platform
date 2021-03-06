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
package net.dynamichorizons.rp.rest.service.menu;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

import net.dynamichorizons.rp.domain.exceptions.ContentNotFoundException;
import net.dynamichorizons.rp.domain.menu.Menu;
import net.dynamichorizons.rp.service.menu.MenuDownloadService;
import net.dynamichorizons.rp.service.menu.MenuService;
import net.dynamichorizons.rp.stereotype.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@WebService
@Path( "/menu" )
@Produces( { MediaType.APPLICATION_JSON, MediaType.TEXT_XML } )
public class MenuWebServiceImpl
    implements MenuWebService
{

    final static Logger logger = LoggerFactory.getLogger( MenuWebServiceImpl.class );

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuDownloadService menuDownloadService;

    @GET
    public Menu[] getMenus()
    {
        List<Menu> menus = menuService.getAllMenus();
        Menu[] result = menus.toArray( new Menu[menus.size()] );

        if ( result != null )
        {
            return result;
        }
        else
        {
            throw new ContentNotFoundException();
        }
    }

    @GET
    @Path( "/{menuKey}" )
    public Menu getMenu( @PathParam( "menuKey" )
    String menuKey )
    {
        Menu result = menuService.getMenuByMenuKey( menuKey );

        if ( result != null )
        {
            return result;
        }
        else
        {
            throw new ContentNotFoundException();
        }
    }

    @GET
    @Path( "/download/{menuKey}" )
    @Produces( { "application/pdf" } )
    public StreamingOutput getMenuDownload( @PathParam( "menuKey" )
    String menuKey )
    {
        final Menu result = menuService.getMenuByMenuKey( menuKey );

        if ( result != null )
        {
            return new StreamingOutput()
            {
                public void write( OutputStream outputStream )
                    throws IOException, WebApplicationException
                {
                    try
                    {
                        menuDownloadService.generateMenu( result, outputStream );
                    }
                    catch ( Exception e )
                    {
                        throw new WebApplicationException( e );
                    }
                }
            };
        }
        else
        {
            throw new ContentNotFoundException();
        }
    }
}

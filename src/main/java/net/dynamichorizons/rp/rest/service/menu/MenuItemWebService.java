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

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import net.dynamichorizons.rp.domain.exceptions.ContentNotFoundException;
import net.dynamichorizons.rp.domain.menu.MenuItem;
import net.dynamichorizons.rp.stereotype.WebService;
import net.dynamichorizons.rp.store.menu.MenuItemRepository;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;

@WebService
@Path( "/menu/item" )
public class MenuItemWebService
{

    @Autowired
    private MenuItemRepository menuItemRepository;

    @GET
    public MenuItem[] getMenuItems()
    {
        MenuItem[] result =
            (MenuItem[]) IteratorUtils.toArray( menuItemRepository.findAll().iterator(), MenuItem.class );

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
    @Path( "/{menuItemId}" )
    public MenuItem getMenuItem( @PathParam( "menuItemId" )
    Long menuItemId )
    {
        MenuItem result = menuItemRepository.findOne( menuItemId );

        if ( result != null )
        {
            return result;
        }
        else
        {
            throw new ContentNotFoundException();
        }
    }

    @POST
    public MenuItem createMenuItem( MenuItem menuItem )
    {
        MenuItem result = menuItemRepository.save( menuItem );

        if ( result != null )
        {
            return result;
        }
        else
        {
            throw new ContentNotFoundException();
        }
    }

    @PUT
    @Path( "/{menuItemId}" )
    public MenuItem modifyMenuItem( @PathParam( "menuItemId" )
    Long menuItemId, MenuItem menuItem )
    {
        MenuItem result = menuItemRepository.save( menuItem );

        if ( result != null )
        {
            return result;
        }
        else
        {
            throw new ContentNotFoundException();
        }
    }

    @DELETE
    @Path( "/{menuItemId}" )
    public void deleteMenuItem( @PathParam( "menuItemId" )
    Long menuItemId )
    {
        menuItemRepository.delete( menuItemId );
    }
}

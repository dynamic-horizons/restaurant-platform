package net.dynamichorizons.rp.rest.service.menu;

import java.util.UUID;

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
    UUID menuItemId )
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
    UUID menuItemId, MenuItem menuItem )
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
    UUID menuItemId )
    {
        menuItemRepository.delete( menuItemId );
    }
}

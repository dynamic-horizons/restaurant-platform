package net.dynamichorizons.rp.rest.service.menu;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

import net.dynamichorizons.rp.domain.exceptions.ContentNotFoundException;
import net.dynamichorizons.rp.domain.menu.Menu;
import net.dynamichorizons.rp.service.MenuDownloadService;
import net.dynamichorizons.rp.service.MenuService;
import net.dynamichorizons.rp.stereotype.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@WebService
@Path( "/menu" )
@Produces( { MediaType.APPLICATION_JSON, MediaType.TEXT_XML } )
public class MenuWebService
{

    final static Logger logger = LoggerFactory.getLogger( MenuWebService.class );

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
    @Path( "/menuMap" )
    public Map<String, String> getMenuMap()
    {
        Map<String, String> result = menuService.getMenuKeyNameMap();

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
    @Path( "/menuGroupMap" )
    public Map<String, Map<String, UUID>> getMenuGroupMap()
    {
        Map<String, Map<String, UUID>> result = menuService.getMenuGroupMap();

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

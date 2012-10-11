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

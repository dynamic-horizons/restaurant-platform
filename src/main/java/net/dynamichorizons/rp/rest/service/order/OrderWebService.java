package net.dynamichorizons.rp.rest.service.order;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.dynamichorizons.rp.stereotype.WebService;

@WebService
@Path( "/order" )
@Produces( { MediaType.APPLICATION_JSON, MediaType.TEXT_XML } )
public class OrderWebService
{

}

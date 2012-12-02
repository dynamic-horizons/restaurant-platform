package net.dynamichorizons.rp.rest.service.order;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import net.dynamichorizons.rp.domain.order.AddOrderMenuSelectionRequest;
import net.dynamichorizons.rp.domain.order.CreateOrderRequest;
import net.dynamichorizons.rp.domain.order.Order;
import net.dynamichorizons.rp.service.order.OrderService;
import net.dynamichorizons.rp.stereotype.WebService;

@WebService
@Path( "/order" )
@Produces( { MediaType.APPLICATION_JSON, MediaType.TEXT_XML } )
public class OrderWebServiceImpl
    implements OrderWebService
{
    @Autowired
    private OrderService orderService;

    @GET
    public Order getCurrentOrder()
    {
        return orderService.getCurrentOrder();
    }

    @POST
    public Order createOrder( CreateOrderRequest createOrder )
    {
        return orderService.createOrder( createOrder );
    }

    @POST
    @Path( "/add" )
    public Order addMenuItem( AddOrderMenuSelectionRequest orderMenuSelectionRequest )
    {
        return orderService.addMenuItem( orderMenuSelectionRequest );
    }

    @POST
    @Path( "/remove/{orderMenuSelectionId}" )
    public Order removeMenuItem(@PathParam("orderMenuSelectionId") Long orderMenuSelectionId )
    {
        return orderService.removeMenuItem( orderMenuSelectionId );
    }

    @DELETE
    public void cancelCurrentOrder()
    {
        orderService.cancelCurrentOrder();
    }
}

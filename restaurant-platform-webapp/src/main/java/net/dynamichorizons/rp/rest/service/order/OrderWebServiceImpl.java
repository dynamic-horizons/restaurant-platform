package net.dynamichorizons.rp.rest.service.order;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.dynamichorizons.rp.domain.exceptions.ContentNotFoundException;
import net.dynamichorizons.rp.domain.order.CreateOrderRequest;
import net.dynamichorizons.rp.domain.order.Order;
import net.dynamichorizons.rp.domain.order.OrderPrintRequest;
import net.dynamichorizons.rp.service.order.OrderPrintingService;
import net.dynamichorizons.rp.service.order.OrderService;
import net.dynamichorizons.rp.stereotype.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService
@Path( "/order" )
@Produces( { MediaType.APPLICATION_JSON, MediaType.TEXT_XML } )
public class OrderWebServiceImpl
    implements OrderWebService
{
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderPrintingService orderPrintingService;

    @Override
    @GET
    public Order getCurrentOrder()
    {
        return orderService.getCurrentOrder();
    }

    @GET
    @Path( "/{orderId}" )
    @Override
    public Order getOrder( @PathParam( "orderId" )
    Long orderId )
    {

        Order order = orderService.getCurrentOrder();

        if ( order != null && order.getId().equals( orderId ) )
        {
            return order;
        }
        else
        {
            order = orderService.getOrder( orderId );

            if ( order != null )
            {
                return order;
            }
        }

        throw new ContentNotFoundException();
    }

    @Override
    @POST
    public Order createOrder( CreateOrderRequest createOrder )
    {
        return orderService.createOrder( createOrder );
    }

    @Override
    @GET
    @Path( "/print" )
    public List<Order> getOrdersToPrint()
    {
        return orderPrintingService.getOrdersToBePrinted();
    }

    @Override
    @POST
    @Path( "/print/{orderId}" )
    public void printOrder( @PathParam( "orderId" )
    Long orderId, OrderPrintRequest orderPrintRequest )
    {
        Order order = orderService.getCurrentOrder();

        if ( order != null && order.getId().equals( orderId ) )
        {
            orderPrintingService.printOrder( order, orderPrintRequest );

            return;
        }
        else
        {
            order = orderService.getOrder( orderId );

            if ( order != null )
            {
                orderPrintingService.printOrder( order, orderPrintRequest );

                return;
            }
        }

        throw new ContentNotFoundException();
    }

    @Override
    @DELETE
    public void cancelCurrentOrder()
    {
        orderService.cancelCurrentOrder();
    }
}

package net.dynamichorizons.rp.rest.service.order;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.dynamichorizons.rp.domain.exceptions.ContentNotFoundException;
import net.dynamichorizons.rp.domain.exceptions.InvalidDataException;
import net.dynamichorizons.rp.domain.order.Order;
import net.dynamichorizons.rp.domain.order.OrderMenuSelection;
import net.dynamichorizons.rp.service.order.OrderService;
import net.dynamichorizons.rp.stereotype.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService
@Path( "/order/selection" )
@Produces( MediaType.APPLICATION_JSON )
public class OrderMenuSelectionWebServiceImpl
    implements OrderMenuSelectionWebService
{

    @Autowired
    private OrderService orderService;

    @GET
    @Override
    public List<OrderMenuSelection> getAll()
    {
        Order order = orderService.getCurrentOrder();

        if ( order != null )
        {
            return order.getOrderMenuSelections();
        }
        else
        {
            throw new ContentNotFoundException();
        }
    }

    @GET
    @Path( "/{orderMenuSelectionId}" )
    @Override
    public OrderMenuSelection getOne( @PathParam( "orderMenuSelectionId" )
    Long orderMenuSelectionId )
    {

        Order order = orderService.getCurrentOrder();

        if ( order != null )
        {
            for ( OrderMenuSelection orderMenuSelection : order.getOrderMenuSelections() )
            {
                if ( orderMenuSelection.getId().equals( orderMenuSelectionId ) )
                {
                    return orderMenuSelection;
                }
            }
        }

        throw new ContentNotFoundException();
    }

    @POST
    @Override
    public OrderMenuSelection create( OrderMenuSelection orderMenuSelection )
    {
        return orderService.addOrderMenuSelection( orderMenuSelection );
    }

    @PUT
    @Path( "/{orderMenuSelectionId}" )
    @Override
    public OrderMenuSelection modify( @PathParam( "orderMenuSelectionId" )
    Long orderMenuSelectionId, OrderMenuSelection orderMenuSelection )
    {
        if ( !orderMenuSelectionId.equals( orderMenuSelection.getId() ) )
        {
            throw new InvalidDataException();
        }

        return orderService.modifyOrderMenuSelection( orderMenuSelection );
    }

    @DELETE
    @Path( "/{orderMenuSelectionId}" )
    @Override
    public void delete( @PathParam( "orderMenuSelectionId" )
    Long orderMenuSelectionId )
    {
        orderService.removeMenuItem( orderMenuSelectionId );
    }

}

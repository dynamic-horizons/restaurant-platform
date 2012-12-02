package net.dynamichorizons.rp.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.dynamichorizons.rp.domain.InitializeApplicationResponse;
import net.dynamichorizons.rp.domain.LoginRequest;
import net.dynamichorizons.rp.domain.customer.Customer;
import net.dynamichorizons.rp.domain.exceptions.InvalidDataException;
import net.dynamichorizons.rp.domain.exceptions.LoginException;
import net.dynamichorizons.rp.service.UserService;
import net.dynamichorizons.rp.service.customer.CustomerService;
import net.dynamichorizons.rp.service.menu.MenuService;
import net.dynamichorizons.rp.service.order.OrderService;
import net.dynamichorizons.rp.stereotype.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService
@Path( "/" )
public class RestaurantWebServiceImpl
    implements RestaurantWebService
{

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private MenuService menuService;
    
    @Autowired
    private OrderService orderService;

    @GET
    @Produces( MediaType.TEXT_PLAIN )
    @Override
    public String defaultService()
    {
        return "Restaurant Platform REST Service";
    }

    @GET
    @Path( "/build" )
    @Produces( MediaType.TEXT_PLAIN )
    @Override
    public String buildInformation()
    {
        return "Restaurant Platform - V1.0";
    }
    
    @GET
    @Path( "/load")
    @Override
    public InitializeApplicationResponse load()
    {
        InitializeApplicationResponse response = new InitializeApplicationResponse();
        
        response.setCustomer( customerService.getCustomer() );
        response.setMenuMap( menuService.getMenuKeyNameMap() );
        response.setCurrentOrder( orderService.getCurrentOrder() );
        
        return response;
    }

    @POST
    @Path( "/login" )
    @Override
    public Customer login( LoginRequest loginToken )
        throws LoginException
    {
        Customer result =
            customerService.login( loginToken.getUsername(), loginToken.getPassword(), loginToken.isRememberMe() );
        if ( result != null )
        {
            return result;
        }
        else
        {
            throw new InvalidDataException();
        }
    }

    @GET
    @Path( "/logout" )
    @Produces( MediaType.TEXT_PLAIN )
    public String logout()
    {
        userService.logout();
        return "USER LOGGED OUT";
    }

}

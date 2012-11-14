package net.dynamichorizons.rp.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.dynamichorizons.rp.domain.Customer;
import net.dynamichorizons.rp.domain.LoginToken;
import net.dynamichorizons.rp.domain.exceptions.InvalidDataException;
import net.dynamichorizons.rp.domain.exceptions.LoginException;
import net.dynamichorizons.rp.service.CustomerService;
import net.dynamichorizons.rp.service.UserService;
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

    @POST
    @Path( "/login" )
    @Override
    public Customer login( LoginToken loginToken )
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

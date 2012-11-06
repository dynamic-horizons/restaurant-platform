package net.dynamichorizons.rp.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.dynamichorizons.rp.domain.Address;
import net.dynamichorizons.rp.domain.Customer;
import net.dynamichorizons.rp.domain.PhoneNumber;
import net.dynamichorizons.rp.domain.State;
import net.dynamichorizons.rp.domain.User;
import net.dynamichorizons.rp.domain.exceptions.ContentNotFoundException;
import net.dynamichorizons.rp.service.CustomerService;
import net.dynamichorizons.rp.stereotype.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService
@Path( "/customer" )
@Produces( { MediaType.APPLICATION_JSON, MediaType.TEXT_XML } )
public class CustomerWebService
{

    @Autowired
    private CustomerService customerService;
    
    @GET
    public Customer getCustomer() {
        Customer cust = new Customer();
        User user = new User();
        user.setFirstName( "TEST" );
        user.setLastName( "L_TEST" );
        user.setEmailAddress( "n@na.com" );
        
        cust.getAddresses().add( new Address( "1111", "Lakeville", State.MN, "55068" ) );
        
        cust.getPhoneNumbers().add( new PhoneNumber( "952-994-5399" ) );
        
        cust.setUser( user );
        
        return cust;
    }

    @POST
    public Customer createCustomer( Customer customer )
    {
        Customer result = customerService.createCustomer( customer );

        if ( result != null )
        {
            return result;
        }
        else
        {
            throw new ContentNotFoundException();
        }
    }
}

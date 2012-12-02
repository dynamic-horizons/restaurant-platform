package net.dynamichorizons.rp.rest.service.customer;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.dynamichorizons.rp.domain.customer.Customer;
import net.dynamichorizons.rp.domain.customer.PhoneNumber;
import net.dynamichorizons.rp.domain.exceptions.ContentNotFoundException;
import net.dynamichorizons.rp.domain.exceptions.InvalidDataException;
import net.dynamichorizons.rp.service.customer.CustomerService;
import net.dynamichorizons.rp.stereotype.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService
@Path( "/customer/phoneNumber" )
@Produces( MediaType.APPLICATION_JSON )
public class CustomerPhoneNumberWebServiceImpl
    implements CustomerPhoneNumberWebService
{

    @Autowired
    private CustomerService customerService;

    @GET
    @Override
    public List<PhoneNumber> getAll()
    {
        Customer customer = customerService.getCustomer();

        if ( customer != null )
        {
            return customer.getPhoneNumbers();
        }
        else
        {
            throw new ContentNotFoundException();
        }
    }

    @GET
    @Path( "/{phoneNumberId}" )
    @Override
    public PhoneNumber getOne( @PathParam( "phoneNumberId" )
    Long phoneNumberId )
    {
        Customer customer = customerService.getCustomer();

        if ( customer != null )
        {
            for ( PhoneNumber phoneNumber : customer.getPhoneNumbers() )
            {
                if ( phoneNumber.getId().equals( phoneNumberId ) )
                {
                    return phoneNumber;
                }
            }
        }

        throw new ContentNotFoundException();
    }

    @POST
    @Override
    public PhoneNumber create( PhoneNumber phoneNumber )
    {
        return customerService.addPhoneNumber( phoneNumber );
    }

    @PUT
    @Path( "/{phoneNumberId}" )
    @Override
    public PhoneNumber modify( @PathParam( "phoneNumberId" )
    Long phoneNumberId, PhoneNumber phoneNumber )
    {
        if ( !phoneNumberId.equals( phoneNumber.getId() ) )
        {
            throw new InvalidDataException();
        }
        
        return customerService.modifyPhoneNumber( phoneNumber );
    }

    @DELETE
    @Path( "/{phoneNumberId}" )
    @Override
    public void delete( @PathParam( "phoneNumberId" )
    Long phoneNumberId )
    {
        customerService.deletePhoneNumber( phoneNumberId );
    }

}

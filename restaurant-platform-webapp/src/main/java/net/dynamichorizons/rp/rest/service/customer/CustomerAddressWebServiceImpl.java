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

import net.dynamichorizons.rp.domain.customer.Address;
import net.dynamichorizons.rp.domain.customer.Customer;
import net.dynamichorizons.rp.domain.exceptions.ContentNotFoundException;
import net.dynamichorizons.rp.domain.exceptions.InvalidDataException;
import net.dynamichorizons.rp.service.customer.CustomerService;
import net.dynamichorizons.rp.stereotype.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService
@Path( "/customer/address" )
@Produces( MediaType.APPLICATION_JSON )
public class CustomerAddressWebServiceImpl
    implements CustomerAddressWebService
{

    @Autowired
    private CustomerService customerService;

    @GET
    @Override
    public List<Address> getAll()
    {
        Customer customer = customerService.getCustomer();

        if ( customer != null )
        {
            return customer.getAddresses();
        }
        else
        {
            throw new ContentNotFoundException();
        }
    }

    @GET
    @Path( "/{addressId}" )
    @Override
    public Address getOne( @PathParam( "addressId" )
    Long addressId )
    {
        Customer customer = customerService.getCustomer();

        if ( customer != null )
        {
            for ( Address address : customer.getAddresses() )
            {
                if ( address.getId().equals( addressId ) )
                {
                    return address;
                }
            }
        }

        throw new ContentNotFoundException();
    }

    @POST
    @Override
    public Address create( Address address )
    {
        return customerService.addAddress( address );
    }

    @PUT
    @Path( "/{addressId}" )
    @Override
    public Address modify( @PathParam( "addressId" )
    Long addressId, Address address )
    {
        if ( !addressId.equals( address.getId() ) )
        {
            throw new InvalidDataException();
        }

        return customerService.modifyAddress( address );
    }

    @DELETE
    @Path( "/{addressId}" )
    @Override
    public void delete( @PathParam( "addressId" )
    Long addressId )
    {
        customerService.deleteAddress( addressId );
    }

}

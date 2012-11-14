package net.dynamichorizons.rp.rest.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.dynamichorizons.rp.domain.Customer;
import net.dynamichorizons.rp.domain.ValidationError;
import net.dynamichorizons.rp.domain.exceptions.DatabaseException;
import net.dynamichorizons.rp.domain.exceptions.InvalidDataException;
import net.dynamichorizons.rp.domain.exceptions.LoginException;
import net.dynamichorizons.rp.domain.exceptions.UserExistsException;
import net.dynamichorizons.rp.service.CustomerService;
import net.dynamichorizons.rp.stereotype.WebService;

import org.springframework.beans.factory.annotation.Autowired;

@WebService
@Path( "/customer" )
@Produces( MediaType.APPLICATION_JSON )
public class CustomerWebServiceImpl
    implements CustomerWebService
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    private Validator validator;

    @GET
    public Customer getCustomer()
    {
        Customer result = customerService.getCustomer();

        if ( result != null )
        {
            return result;
        }
        else
        {
            throw new InvalidDataException();
        }
    }

    @POST
    @Path( "/register" )
    public Customer registerCustomer( Customer customer )
    {
        Customer result = null;

        Set<ConstraintViolation<Customer>> validationErrors = validator.validate( customer );
        if ( validationErrors.size() > 0 )
        {
            throw new InvalidDataException( ValidationError.fromConstraintViolations( validationErrors ) );
        }

        try
        {
            result = customerService.createCustomer( customer );
        }
        catch ( UserExistsException e )
        {
            throw new InvalidDataException();
        }
        catch ( LoginException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch ( DatabaseException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if ( result != null )
        {
            return result;
        }
        else
        {
            throw new InvalidDataException();
        }
    }
}

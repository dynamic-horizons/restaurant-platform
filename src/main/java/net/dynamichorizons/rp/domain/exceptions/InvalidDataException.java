package net.dynamichorizons.rp.domain.exceptions;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.dynamichorizons.rp.domain.ValidationError;

public class InvalidDataException
    extends WebApplicationException
{

    private static final long serialVersionUID = 5804218402783869379L;

    public InvalidDataException()
    {
        super( Response.Status.BAD_REQUEST );
    }

    public InvalidDataException( List<ValidationError> validationErrors )
    {
        super( Response.status( Status.BAD_REQUEST ).entity( validationErrors ).type( MediaType.APPLICATION_JSON_TYPE ).build() );
    }

    public InvalidDataException( Throwable exception )
    {
        super( exception, Response.Status.BAD_REQUEST );
    }

}

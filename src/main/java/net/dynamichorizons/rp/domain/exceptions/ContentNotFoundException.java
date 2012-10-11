package net.dynamichorizons.rp.domain.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ContentNotFoundException
    extends WebApplicationException
{

    private static final long serialVersionUID = -6275589246975420266L;

    public ContentNotFoundException()
    {
        super( Response.Status.NOT_FOUND );
    }

    public ContentNotFoundException( Throwable exception )
    {
        super( exception, Response.Status.NOT_FOUND );
    }

}

package net.dynamichorizons.rp.domain.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class LoginException
    extends WebApplicationException
{

    private static final long serialVersionUID = 6504982899746623594L;

    public LoginException()
    {
        super( Response.Status.UNAUTHORIZED );
    }

}

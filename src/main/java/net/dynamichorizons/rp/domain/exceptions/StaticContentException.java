package net.dynamichorizons.rp.domain.exceptions;

public class StaticContentException
    extends Exception
{

    private static final long serialVersionUID = 1125889718805926277L;

    public StaticContentException()
    {
        super();
    }

    public StaticContentException( String message, Throwable exception )
    {
        super( message, exception );
    }

    public StaticContentException( String message )
    {
        super( message );
    }

    public StaticContentException( Throwable exception )
    {
        super( exception );
    }
}

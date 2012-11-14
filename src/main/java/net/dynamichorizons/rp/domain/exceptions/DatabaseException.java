package net.dynamichorizons.rp.domain.exceptions;

public class DatabaseException
    extends Exception
{
    private static final long serialVersionUID = 5939587370123731463L;

    public DatabaseException( Exception e )
    {
        super( e );
    }

}

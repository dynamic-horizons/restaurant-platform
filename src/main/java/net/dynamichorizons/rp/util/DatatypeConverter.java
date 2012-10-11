package net.dynamichorizons.rp.util;

import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class DatatypeConverter
{

    public static UUID parseUuid( String xmlValue )
    {
        return UUID.fromString( xmlValue );
    }

    public static String printUuid( UUID value )
    {
        return value.toString();
    }

    public static DateTime parseDateTime( String s )
    {
        return new DateTime( s );
    }

    public static String printDateTime( DateTime dt )
    {
        return dt.toString();
    }

    public static LocalDate parseDate( String s )
    {
        return new LocalDate( s );
    }

    public static String printDate( LocalDate ld )
    {
        return ld.toString();
    }

    public static LocalTime parseTime( String s )
    {
        return new LocalTime( s );
    }

    public static String printTime( LocalTime lt )
    {
        return lt.toString();
    }
}

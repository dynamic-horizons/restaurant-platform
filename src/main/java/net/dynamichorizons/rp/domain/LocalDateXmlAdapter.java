//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.20 at 06:12:49 PM CDT 
//

package net.dynamichorizons.rp.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.LocalDate;

public class LocalDateXmlAdapter
    extends XmlAdapter<String, LocalDate>
{

    public LocalDate unmarshal( String value )
    {
        return ( net.dynamichorizons.rp.util.DatatypeConverter.parseDate( value ) );
    }

    public String marshal( LocalDate value )
    {
        return ( net.dynamichorizons.rp.util.DatatypeConverter.printDate( value ) );
    }

}
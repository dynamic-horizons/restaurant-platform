package net.dynamichorizons.rp.rest.service;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
public class JAXBContextProvider
    implements ContextResolver<JAXBContext>
{

    private JAXBContext context;

    public JAXBContextProvider()
        throws JAXBException
    {
        JSONConfiguration jsonConfiguration = JSONConfiguration.natural().rootUnwrapping( true ).build();

        context = new JSONJAXBContext( jsonConfiguration, "net.dynamichorizons.rp.domain" );
    }

    @Override
    public JAXBContext getContext( Class<?> type )
    {
        return context;
    }

}

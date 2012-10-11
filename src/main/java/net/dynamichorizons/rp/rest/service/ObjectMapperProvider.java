package net.dynamichorizons.rp.rest.service;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@Provider
public class ObjectMapperProvider
    implements ContextResolver<ObjectMapper>
{

    private ObjectMapper objectMapper;

    public ObjectMapperProvider()
    {
        objectMapper = new ObjectMapper();

        Hibernate4Module hm = new Hibernate4Module();

        objectMapper.registerModule( hm );

        hm.configure( Hibernate4Module.Feature.FORCE_LAZY_LOADING, false );
    }

    @Override
    public ObjectMapper getContext( Class<?> type )
    {
        return objectMapper;
    }

}

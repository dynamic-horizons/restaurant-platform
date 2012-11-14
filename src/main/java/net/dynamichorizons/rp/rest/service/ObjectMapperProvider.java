/**
 * Copyright (C) 2012 Dynamic Horizons, LLC <https://www.dynamichorizons.net>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 *   
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package net.dynamichorizons.rp.rest.service;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
        hm.configure( Hibernate4Module.Feature.FORCE_LAZY_LOADING, false );

        objectMapper.registerModule( hm );
        objectMapper.configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false );
    }

    @Override
    public ObjectMapper getContext( Class<?> type )
    {
        return objectMapper;
    }

}

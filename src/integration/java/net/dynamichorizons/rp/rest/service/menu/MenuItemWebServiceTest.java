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
package net.dynamichorizons.rp.rest.service.menu;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MenuItemWebServiceTest
{
    private Client client;
    
    public MenuItemWebServiceTest() {
        client = Client.create();
    }

    @Test
    public void testGetMenuItems()
    {
        WebResource webResource = client.resource( "http://localhost:8080//metallica/get" );

        ClientResponse response = webResource.accept( "application/json" ).get( ClientResponse.class );

        if ( response.getStatus() != 200 )
        {
            throw new RuntimeException( "Failed : HTTP error code : " + response.getStatus() );
        }

        String output = response.getEntity( String.class );

        System.out.println( "Output from Server .... \n" );
        System.out.println( output );
    }

    @Test
    public void testGetMenuItem()
    {
        fail( "Not yet implemented" );
    }

    @Test
    public void testCreateMenuItem()
    {
        fail( "Not yet implemented" );
    }

    @Test
    public void testModifyMenuItem()
    {
        fail( "Not yet implemented" );
    }

    @Test
    public void testDeleteMenuItem()
    {
        fail( "Not yet implemented" );
    }

}

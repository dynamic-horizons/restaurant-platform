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

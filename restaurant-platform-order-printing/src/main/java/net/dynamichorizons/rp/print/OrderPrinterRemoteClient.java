package net.dynamichorizons.rp.print;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.dynamichorizons.rp.domain.order.Order;
import net.dynamichorizons.rp.domain.order.OrderPrintRequest;
import net.dynamichorizons.rp.domain.order.OrderPrintRequestType;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderPrinterRemoteClient
{
    private static final Logger LOG = LoggerFactory.getLogger( OrderPrinterRemoteClient.class );

    private static final String CONFIG_FILE = "rp-order-printer.properties";

    private static final String HOST_URL = "host.url";

    private HttpClient httpclient = new DefaultHttpClient();

    private ObjectMapper mapper = new ObjectMapper();

    private HttpGet getRequest;

    private HttpPost postRequest;

    private Configuration config;

    public OrderPrinterRemoteClient()
        throws ConfigurationException
    {
        config = new PropertiesConfiguration( CONFIG_FILE );
        getRequest = new HttpGet( config.getString( HOST_URL ) );
    }

    @SuppressWarnings( "unchecked" )
    public List<Order> getOrdersToPrint()
    {
        LOG.info( "GETTING ORDERS TO PRINT" );

        List<Order> orders = new ArrayList<>();

        try
        {
            HttpResponse response = httpclient.execute( getRequest );
            HttpEntity entity = null;

            if ( response.getStatusLine().getStatusCode() == 200 && ( entity = response.getEntity() ) != null )
            {
                InputStream instream = entity.getContent();
                try
                {
                    orders.addAll( (Collection<? extends Order>) mapper.readValue( instream,
                                                                                   new TypeReference<List<Order>>()
                                                                                   {
                                                                                   } ) );
                }
                finally
                {
                    instream.close();
                }
            }
        }
        catch ( Exception e )
        {
            LOG.error( "CAUGHT EXCEPTION GETTING ORDERS", e );
        }

        LOG.info( "GOT " + orders.size() + " ORDERS TO PRINT" );

        getRequest.reset();

        return orders;
    }

    public void updateOrderPrintDate( Order order )
    {
        postRequest = new HttpPost( config.getString( HOST_URL + "/" + order.getId() ) );
        postRequest.addHeader( "Accept", "application/json" );
        postRequest.addHeader( "Content-Type", "application/json" );

        OrderPrintRequest orderPrintRequest = new OrderPrintRequest();
        orderPrintRequest.setOrderPrintRequestType( OrderPrintRequestType.UPDATE );
        orderPrintRequest.setPrintDate( new DateTime() );

        StringEntity entity;
        try
        {
            entity = new StringEntity( mapper.writeValueAsString( orderPrintRequest ), "UTF-8" );

            entity.setContentType( "application/json" );

            postRequest.setEntity( entity );

            HttpResponse response = httpclient.execute( postRequest );

            if ( response.getStatusLine().getStatusCode() != 200 )
            {
                LOG.error( "Order Print Date Was Not Updated" );
            }
        }
        catch ( Exception e )
        {
            LOG.error( "Order Print Date Was Not Updated" );
        }

        postRequest.reset();
    }
}

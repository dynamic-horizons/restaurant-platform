package net.dynamichorizons.rp.service;

import java.io.IOException;

import net.dynamichorizons.rp.domain.exceptions.StaticContentException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StaticContentServiceImpl
    implements StaticContentService
{

    Logger logger = LoggerFactory.getLogger( StaticContentServiceImpl.class );

    @Override
    public String getStaticContentPage( String pageName )
    {
        return "<h1>Test Static Content Page</h1>";
    }

    @Override
    public String getTemplate( String templateName )
        throws StaticContentException
    {
        try
        {
            return IOUtils.toString( getClass().getResourceAsStream( "/templates/" + templateName.replace( ".", "/" )
                                                                         + ".tpl" ) );
        }
        catch ( IOException e )
        {
            throw new StaticContentException();
        }
    }
}

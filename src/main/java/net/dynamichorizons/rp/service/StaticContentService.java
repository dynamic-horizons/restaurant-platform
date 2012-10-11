package net.dynamichorizons.rp.service;

import net.dynamichorizons.rp.domain.exceptions.StaticContentException;

public interface StaticContentService
{

    public String getStaticContentPage( String pageName )
        throws StaticContentException;

    public String getTemplate( String templateName )
        throws StaticContentException;

}

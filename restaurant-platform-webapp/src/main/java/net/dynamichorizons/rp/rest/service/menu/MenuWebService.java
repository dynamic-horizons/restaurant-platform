package net.dynamichorizons.rp.rest.service.menu;

import javax.ws.rs.core.StreamingOutput;

import net.dynamichorizons.rp.domain.menu.Menu;

public interface MenuWebService
{
    public Menu[] getMenus();

    public Menu getMenu( String menuKey );

    public StreamingOutput getMenuDownload( String menuKey );
}

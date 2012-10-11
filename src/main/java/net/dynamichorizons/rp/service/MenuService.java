package net.dynamichorizons.rp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.annotation.PostConstruct;

import net.dynamichorizons.rp.domain.menu.Menu;
import net.dynamichorizons.rp.domain.menu.MenuGroup;
import net.dynamichorizons.rp.domain.menu.MenuItem;
import net.dynamichorizons.rp.store.menu.MenuItemImageUrlRepository;
import net.dynamichorizons.rp.store.menu.MenuItemOptionRepository;
import net.dynamichorizons.rp.store.menu.MenuItemRepository;
import net.dynamichorizons.rp.store.menu.MenuItemSizeRepository;
import net.dynamichorizons.rp.store.menu.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope( value = WebApplicationContext.SCOPE_APPLICATION )
public class MenuService
{
    // private final static Logger logger = LoggerFactory.getLogger( MenuService.class );

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private MenuItemSizeRepository menuItemSizeRepository;

    @Autowired
    private MenuItemOptionRepository menuItemOptionRepository;

    @Autowired
    private MenuItemImageUrlRepository menuItemImageUrlRepository;

    /**
     * Menu Cache
     */
    private Map<String, Menu> menuCache = null;

    public List<Menu> getAllMenus()
    {

        cacheMenus();

        return new ArrayList<Menu>( menuCache.values() );
    }

    public Map<String, String> getMenuKeyNameMap()
    {
        cacheMenus();

        Map<String, String> menuKeyNameMap = new HashMap<String, String>();
        for ( Entry<String, Menu> menuEntry : menuCache.entrySet() )
        {
            menuKeyNameMap.put( menuEntry.getKey(), menuEntry.getValue().getName() );
        }

        return menuKeyNameMap;
    }

    public Map<String, Map<String, UUID>> getMenuGroupMap()
    {
        cacheMenus();

        Map<String, Map<String, UUID>> menuGroupMap = new HashMap<String, Map<String, UUID>>();
        for ( Menu menu : menuCache.values() )
        {
            Map<String, UUID> menuIdMap = new HashMap<String, UUID>();
            for ( MenuGroup menuGroup : menu.getMenuGroups() )
            {
                menuIdMap.put( menuGroup.getName(), menuGroup.getUid() );
            }

            menuGroupMap.put( menu.getName(), menuIdMap );
        }

        return menuGroupMap;
    }

    public Menu getMenuByMenuKey( String menuKey )
    {
        cacheMenus();

        if ( menuCache.containsKey( menuKey ) )
        {
            return menuCache.get( menuKey );
        }
        else
        {
            return null;
        }
    }

    @PostConstruct
    private void cacheMenus()
    {
        if ( menuCache == null || menuCache.size() != menuRepository.count() )
        {
            Iterator<Menu> menuIterator = menuRepository.findAll().iterator();
            if ( menuIterator.hasNext() )
            {
                menuCache = new HashMap<String, Menu>();

                while ( menuIterator.hasNext() )
                {
                    Menu menu = menuIterator.next();

                    // Inject Menu Item Information
                    injectMenuItemInformation( menu );

                    menuCache.put( menu.getMenuKey(), menu );
                }
            }
        }
    }

    private void injectMenuItemInformation( Menu menu )
    {
        for ( MenuGroup menuGroup : menu.getMenuGroups() )
        {
            menuGroup.setMenuItems( menuItemRepository.findByMenuGroupUid( menuGroup.getUid() ) );

            for ( MenuItem menuItem : menuGroup.getMenuItems() )
            {
                menuItem.setMenuItemImageUrls( menuItemImageUrlRepository.findByMenuGroupItemId( menuItem.getMenuGroupItemId() ) );
                menuItem.setMenuItemOptions( menuItemOptionRepository.findByMenuGroupItemId( menuItem.getMenuGroupItemId() ) );
                menuItem.setMenuItemSizes( menuItemSizeRepository.findByMenuGroupItemId( menuItem.getMenuGroupItemId() ) );
            }
        }
    }
}

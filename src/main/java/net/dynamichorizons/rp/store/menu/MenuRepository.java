package net.dynamichorizons.rp.store.menu;

import java.util.UUID;

import net.dynamichorizons.rp.domain.menu.Menu;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuRepository
    extends PagingAndSortingRepository<Menu, UUID>
{

    public Menu findByMenuKey( String menuKey );

}

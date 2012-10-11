package net.dynamichorizons.rp.store.menu;

import java.util.List;

import net.dynamichorizons.rp.domain.menu.MenuItemSize;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuItemSizeRepository
    extends PagingAndSortingRepository<MenuItemSize, Long>
{
    public List<MenuItemSize> findByMenuGroupItemId( Long menuGroupItemId );
}

package net.dynamichorizons.rp.store.menu;

import java.util.List;

import net.dynamichorizons.rp.domain.menu.MenuItemImage;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuItemImageUrlRepository
    extends PagingAndSortingRepository<MenuItemImage, Long>
{
    public List<MenuItemImage> findByMenuGroupItemId( Long menuGroupItemId );
}

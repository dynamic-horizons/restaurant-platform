package net.dynamichorizons.rp.store.menu;

import java.util.List;

import net.dynamichorizons.rp.domain.menu.MenuItemOption;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuItemOptionRepository
    extends PagingAndSortingRepository<MenuItemOption, Long>
{
    public List<MenuItemOption> findByMenuGroupItemId(Long menuGroupItemId);
}

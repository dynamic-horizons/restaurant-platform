package net.dynamichorizons.rp.store.menu;

import java.util.List;
import java.util.UUID;

import net.dynamichorizons.rp.domain.menu.MenuItem;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuItemRepository
    extends PagingAndSortingRepository<MenuItem, UUID>
{
    public List<MenuItem> findByMenuGroupUid( UUID menuGroupUid );
}

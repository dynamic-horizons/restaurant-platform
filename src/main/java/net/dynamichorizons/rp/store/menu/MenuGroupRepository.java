package net.dynamichorizons.rp.store.menu;

import java.util.List;
import java.util.UUID;

import net.dynamichorizons.rp.domain.menu.MenuGroup;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface MenuGroupRepository
    extends PagingAndSortingRepository<MenuGroup, UUID>
{
    public List<MenuGroup> findByParentMenuUid( UUID menuUid );
}

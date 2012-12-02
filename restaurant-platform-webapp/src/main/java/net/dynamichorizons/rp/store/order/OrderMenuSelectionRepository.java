package net.dynamichorizons.rp.store.order;

import net.dynamichorizons.rp.domain.order.OrderMenuSelection;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderMenuSelectionRepository
    extends PagingAndSortingRepository<OrderMenuSelection, Long>
{

}

package net.dynamichorizons.rp.store.order;

import net.dynamichorizons.rp.domain.order.Order;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository
    extends PagingAndSortingRepository<Order, Long>
{

}

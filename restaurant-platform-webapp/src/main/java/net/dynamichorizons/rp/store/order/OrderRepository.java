package net.dynamichorizons.rp.store.order;

import java.util.Date;

import net.dynamichorizons.rp.domain.order.Order;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository
    extends PagingAndSortingRepository<Order, Long>
{
    @Modifying
    @Query( "update Order o set o.printDate = ?2 where o.id = ?1" )
    public void updatePrintDate( Long orderId, Date printDate );
}

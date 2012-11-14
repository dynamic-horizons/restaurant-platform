package net.dynamichorizons.rp.store;

import net.dynamichorizons.rp.domain.Customer;
import net.dynamichorizons.rp.domain.User;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository
    extends PagingAndSortingRepository<Customer, Long>
{

    public Customer findByUser( User user );

}
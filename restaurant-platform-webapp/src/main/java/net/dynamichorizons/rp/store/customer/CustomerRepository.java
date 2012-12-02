package net.dynamichorizons.rp.store.customer;

import net.dynamichorizons.rp.domain.User;
import net.dynamichorizons.rp.domain.customer.Customer;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository
    extends PagingAndSortingRepository<Customer, Long>
{

    public Customer findByUser( User user );

}
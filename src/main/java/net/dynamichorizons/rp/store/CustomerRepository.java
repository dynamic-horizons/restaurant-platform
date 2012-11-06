package net.dynamichorizons.rp.store;

import net.dynamichorizons.rp.domain.Customer;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository
    extends PagingAndSortingRepository<Customer, Long>
{

}
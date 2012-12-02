package net.dynamichorizons.rp.store.customer;

import net.dynamichorizons.rp.domain.customer.CustomerAddress;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerAddressRepository
    extends PagingAndSortingRepository<CustomerAddress, Long>
{

}
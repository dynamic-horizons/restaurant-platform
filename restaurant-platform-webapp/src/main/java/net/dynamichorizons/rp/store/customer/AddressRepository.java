package net.dynamichorizons.rp.store.customer;

import java.util.List;

import net.dynamichorizons.rp.domain.customer.Address;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository
    extends PagingAndSortingRepository<Address, Long>
{
    public List<Address> findByCustomerIdAndActive( Long customerId, Boolean active );
}
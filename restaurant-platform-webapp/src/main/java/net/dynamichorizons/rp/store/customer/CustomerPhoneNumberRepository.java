package net.dynamichorizons.rp.store.customer;

import net.dynamichorizons.rp.domain.customer.CustomerPhoneNumber;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerPhoneNumberRepository
    extends PagingAndSortingRepository<CustomerPhoneNumber, Long>
{

}
package net.dynamichorizons.rp.store.customer;

import java.util.List;

import net.dynamichorizons.rp.domain.customer.PhoneNumber;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhoneNumberRepository
    extends PagingAndSortingRepository<PhoneNumber, Long>
{
    public List<PhoneNumber> findByCustomerId(Long customerId);
}
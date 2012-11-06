package net.dynamichorizons.rp.service;

import net.dynamichorizons.rp.domain.Customer;
import net.dynamichorizons.rp.store.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService
{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserService userService;

    public Customer createCustomer( Customer customer )
    {
        userService.createUser( customer.getUser() );
        customerRepository.save( customer );

        return customer;
    }
}

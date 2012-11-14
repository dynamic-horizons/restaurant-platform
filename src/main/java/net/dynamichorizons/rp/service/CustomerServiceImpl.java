package net.dynamichorizons.rp.service;

import net.dynamichorizons.rp.domain.Customer;
import net.dynamichorizons.rp.domain.User;
import net.dynamichorizons.rp.domain.exceptions.DatabaseException;
import net.dynamichorizons.rp.domain.exceptions.LoginException;
import net.dynamichorizons.rp.domain.exceptions.UserExistsException;
import net.dynamichorizons.rp.store.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl
    implements CustomerService
{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserService userService;
    
    @Override
    public Customer getCustomer() {
        User user = userService.getUser();
        
        if(user != null) {
            Customer customer = customerRepository.findByUser( user );
            customer.setUser( user );
            
            return customer;
        } else {
            return null;
        }
    }

    @Override
    public Customer login( String username, String password, boolean rememberMe )
        throws LoginException
    {
        User user = userService.login( username, password, rememberMe );
        
        Customer customer =  customerRepository.findByUser( user );
        customer.setUser( user );
        
        return customer;
    }

    @Override
    public Customer createCustomer( Customer customer )
        throws UserExistsException, DatabaseException
    {
        userService.createUser( customer.getUser() );
        
        try {
            customerRepository.save( customer );
        } catch (Exception e) {
            throw new DatabaseException(e);
        }

        return customer;
    }
}

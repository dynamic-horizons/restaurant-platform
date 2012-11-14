package net.dynamichorizons.rp.service;

import net.dynamichorizons.rp.domain.Customer;
import net.dynamichorizons.rp.domain.exceptions.DatabaseException;
import net.dynamichorizons.rp.domain.exceptions.LoginException;
import net.dynamichorizons.rp.domain.exceptions.UserExistsException;

public interface CustomerService
{
    public Customer getCustomer();
    
    public Customer createCustomer( Customer customer )
        throws UserExistsException, LoginException, DatabaseException;

    public Customer login( String username, String password, boolean rememberMe )
        throws LoginException;
}

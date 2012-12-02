package net.dynamichorizons.rp.service.customer;

import net.dynamichorizons.rp.domain.customer.Address;
import net.dynamichorizons.rp.domain.customer.Customer;
import net.dynamichorizons.rp.domain.customer.PhoneNumber;
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

    public Address addAddress( Address address );

    public Address modifyAddress( Address address );

    public void deleteAddress( Long addressId );
    
    public PhoneNumber addPhoneNumber( PhoneNumber address );

    public PhoneNumber modifyPhoneNumber( PhoneNumber address );

    public void deletePhoneNumber( Long phoneNumberId );
}

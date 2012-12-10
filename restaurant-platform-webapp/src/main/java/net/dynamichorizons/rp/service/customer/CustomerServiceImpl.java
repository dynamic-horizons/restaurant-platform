package net.dynamichorizons.rp.service.customer;

import net.dynamichorizons.rp.domain.User;
import net.dynamichorizons.rp.domain.customer.Address;
import net.dynamichorizons.rp.domain.customer.Customer;
import net.dynamichorizons.rp.domain.customer.CustomerAddress;
import net.dynamichorizons.rp.domain.customer.CustomerPhoneNumber;
import net.dynamichorizons.rp.domain.customer.PhoneNumber;
import net.dynamichorizons.rp.domain.exceptions.DatabaseException;
import net.dynamichorizons.rp.domain.exceptions.LoginException;
import net.dynamichorizons.rp.domain.exceptions.UserExistsException;
import net.dynamichorizons.rp.service.UserService;
import net.dynamichorizons.rp.store.customer.AddressRepository;
import net.dynamichorizons.rp.store.customer.CustomerAddressRepository;
import net.dynamichorizons.rp.store.customer.CustomerPhoneNumberRepository;
import net.dynamichorizons.rp.store.customer.CustomerRepository;
import net.dynamichorizons.rp.store.customer.PhoneNumberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional( readOnly = true )
public class CustomerServiceImpl
    implements CustomerService
{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    private CustomerPhoneNumberRepository customerPhoneNumberRepository;

    @Autowired
    private UserService userService;

    @Override
    public Customer getCustomer()
    {
        User user = userService.getUser();

        if ( user != null )
        {
            Customer customer = customerRepository.findByUser( user );
            customer.setUser( user );

            injectCustomerInformation( customer );

            return customer;
        }
        else
        {
            return null;
        }
    }

    @Override
    @Transactional
    public Customer login( String username, String password, boolean rememberMe )
        throws LoginException
    {
        User user = userService.login( username, password, rememberMe );

        Customer customer = customerRepository.findByUser( user );
        customer.setUser( user );

        injectCustomerInformation( customer );

        return customer;
    }

    @Override
    @Transactional
    public Customer createCustomer( Customer customer )
        throws UserExistsException, DatabaseException
    {
        userService.createUser( customer.getUser() );

        try
        {
            customerRepository.save( customer );
        }
        catch ( Exception e )
        {
            throw new DatabaseException( e );
        }

        return customer;
    }

    @Override
    @Transactional
    public Address addAddress( Address address )
    {
        Customer customer = getCustomer();

        addressRepository.save( address );

        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setAddress( address );
        customerAddress.setCustomer( customer );
        customerAddress.setDefaultAddress( address.isDefaultAddress() );

        customerAddressRepository.save( customerAddress );

        customer.getAddresses().add( address );

        return address;
    }

    @Override
    @Transactional
    public Address modifyAddress( Address address )
    {
        Address originalAddress = addressRepository.findOne( address.getId() );
        originalAddress.setAddress1( address.getAddress1() );
        originalAddress.setAddress2( address.getAddress2() );
        originalAddress.setCity( address.getCity() );
        originalAddress.setState( address.getState() );
        originalAddress.setZipCode( address.getZipCode() );
        originalAddress.setDefaultAddress( address.isDefaultAddress() );

        return addressRepository.save( originalAddress );
    }

    @Override
    @Transactional
    public void deleteAddress( Long addressId )
    {
        Customer customer = getCustomer();
        Address addressToRemove = null;

        if ( customer != null )
        {
            for ( Address address : customer.getAddresses() )
            {
                if ( address.getId().equals( addressId ) )
                {
                    addressToRemove = address;
                    break;
                }
            }

            if ( addressToRemove != null )
            {
                customer.getAddresses().remove( addressToRemove );

                customerAddressRepository.delete( addressToRemove.getCustomerAddressId() );
                addressRepository.delete( addressToRemove );
            }
        }
    }

    @Override
    @Transactional
    public PhoneNumber addPhoneNumber( PhoneNumber phoneNumber )
    {
        Customer customer = getCustomer();

        phoneNumberRepository.save( phoneNumber );

        CustomerPhoneNumber customerPhoneNumber = new CustomerPhoneNumber();
        customerPhoneNumber.setPhoneNumber( phoneNumber );
        customerPhoneNumber.setCustomer( customer );
        customerPhoneNumber.setDefaultPhoneNumber( phoneNumber.isDefaultPhoneNumber() );

        customerPhoneNumberRepository.save( customerPhoneNumber );

        customer.getPhoneNumbers().add( phoneNumber );

        return phoneNumber;
    }

    @Override
    @Transactional
    public PhoneNumber modifyPhoneNumber( PhoneNumber phoneNumber )
    {
        PhoneNumber originalPhoneNumber = phoneNumberRepository.findOne( phoneNumber.getId() );
        originalPhoneNumber.setPhoneNumber( phoneNumber.getPhoneNumber() );
        originalPhoneNumber.setPhoneExt( phoneNumber.getPhoneExt() );
        originalPhoneNumber.setPhoneDescription( phoneNumber.getPhoneDescription() );
        originalPhoneNumber.setDefaultPhoneNumber( phoneNumber.isDefaultPhoneNumber() );

        return phoneNumberRepository.save( phoneNumber );
    }

    @Override
    @Transactional
    public void deletePhoneNumber( Long phoneNumberId )
    {
        Customer customer = getCustomer();
        PhoneNumber phoneNumberToRemove = null;

        if ( customer != null )
        {
            for ( PhoneNumber phoneNumber : customer.getPhoneNumbers() )
            {
                if ( phoneNumber.getId().equals( phoneNumberId ) )
                {
                    phoneNumberToRemove = phoneNumber;
                    break;
                }
            }

            if ( phoneNumberToRemove != null )
            {
                customer.getPhoneNumbers().remove( phoneNumberToRemove );

                customerPhoneNumberRepository.delete( phoneNumberToRemove.getCustomerPhoneNumberId() );
                phoneNumberRepository.delete( phoneNumberToRemove );
            }
        }
    }

    private void injectCustomerInformation( Customer customer )
    {
        customer.setAddresses( addressRepository.findByCustomerIdAndActive( customer.getId(), true ) );
        customer.setPhoneNumbers( phoneNumberRepository.findByCustomerIdAndActive( customer.getId(), true ) );
    }
}

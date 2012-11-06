package net.dynamichorizons.rp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

@Entity
@Table( name = "TBL_CUSTOMER" )
@AttributeOverride( name = "id", column = @Column( name = "CUSTOMER_ID" ) )
public class Customer
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = 6390858948389187515L;
    
    @ManyToMany
    @JoinTable(name = "TBL_CUSTOMER_ADDRESS", 
        joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID") })
    private List<Address> addresses;
    
    @ManyToMany
    @JoinTable(name = "TBL_CUSTOMER_PHONE", 
        joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID") })
    private List<PhoneNumber> phoneNumbers;

    @ManyToOne
    @JoinColumn( name = "USER_ID" )
    private User user;

    public List<Address> getAddresses()
    {
        if ( addresses == null )
        {
            addresses = new ArrayList<Address>();
        }
        return addresses;
    }

    public void setAddresses( List<Address> addresses )
    {
        this.addresses = addresses;
    }

    public List<PhoneNumber> getPhoneNumbers()
    {
        if ( phoneNumbers == null )
        {
            phoneNumbers = new ArrayList<PhoneNumber>();
        }
        return phoneNumbers;
    }

    public void setPhoneNumbers( List<PhoneNumber> phoneNumbers )
    {
        this.phoneNumbers = phoneNumbers;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser( User user )
    {
        this.user = user;
    }

}

package net.dynamichorizons.rp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table( name = "TBL_CUSTOMER" )
@AttributeOverride( name = "id", column = @Column( name = "CUSTOMER_ID" ) )
public class Customer
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = 6390858948389187515L;

    @ManyToMany( fetch = FetchType.EAGER )
    @JoinTable( name = "TBL_CUSTOMER_ADDRESS", joinColumns = { @JoinColumn( name = "CUSTOMER_ID" ) }, inverseJoinColumns = { @JoinColumn( name = "ADDRESS_ID" ) } )
    @Fetch( FetchMode.SELECT )
    @Valid
    private List<Address> addresses;

    @ManyToMany( fetch = FetchType.EAGER )
    @JoinTable( name = "TBL_CUSTOMER_PHONE", joinColumns = { @JoinColumn( name = "CUSTOMER_ID" ) }, inverseJoinColumns = { @JoinColumn( name = "PHONE_ID" ) } )
    @Fetch( FetchMode.SELECT )
    @Valid
    private List<PhoneNumber> phoneNumbers;

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "USER_ID" )
    @Fetch( FetchMode.JOIN )
    @Valid
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

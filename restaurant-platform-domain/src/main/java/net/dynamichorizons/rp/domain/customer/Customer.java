package net.dynamichorizons.rp.domain.customer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import net.dynamichorizons.rp.domain.User;
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

    @Valid
    @Transient
    private List<Address> addresses;

    @Valid
    @Transient
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

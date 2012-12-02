package net.dynamichorizons.rp.domain.customer;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

@Entity
@Table( name = "TBL_CUSTOMER_PHONE" )
@AttributeOverride( name = "id", column = @Column( name = "PHONE_ID" ) )
public class CustomerPhoneNumber
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = -1010344212368422087L;
    
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    
    @OneToOne
    @JoinColumn(name = "PHONE_ID")
    private PhoneNumber phoneNumber;

    @Column( name = "DEFAULT_PHONE", nullable = false )
    private Boolean defaultPhoneNumber;

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer( Customer customer )
    {
        this.customer = customer;
    }

    public PhoneNumber getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber( PhoneNumber phoneNumber )
    {
        this.phoneNumber = phoneNumber;
    }                                                                               

    public Boolean isDefaultPhoneNumber()
    {
        return defaultPhoneNumber;
    }

    public void setDefaultPhoneNumber( Boolean defaultPhoneNumber )
    {
        this.defaultPhoneNumber = defaultPhoneNumber;
    }
}

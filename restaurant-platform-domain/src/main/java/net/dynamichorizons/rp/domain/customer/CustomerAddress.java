package net.dynamichorizons.rp.domain.customer;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

@Entity
@Table( name = "TBL_CUSTOMER_ADDRESS" )
@AttributeOverride( name = "id", column = @Column( name = "CUSTOMER_ADDRESS_ID" ) )
public class CustomerAddress
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = -6434211273980658825L;
    
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    
    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;
    
    @Column( name = "DEFAULT_ADDRESS", nullable = false)
    private Boolean defaultAddress;

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer( Customer customer )
    {
        this.customer = customer;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress( Address address )
    {
        this.address = address;
    }

    public Boolean getDefaultAddress()
    {
        return defaultAddress;
    }

    public void setDefaultAddress( Boolean defaultAddress )
    {
        this.defaultAddress = defaultAddress;
    }
    
}

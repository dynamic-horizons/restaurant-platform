package net.dynamichorizons.rp.domain.customer;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;

import net.dynamichorizons.rp.domain.State;
import net.dynamichorizons.rp.domain.base.AbstractEntity;

@Entity
@Table( name = "TBL_ADDRESS" )
@AttributeOverride( name = "id", column = @Column( name = "ADDRESS_ID" ) )
@SecondaryTable( name = "TBL_CUSTOMER_ADDRESS", pkJoinColumns = @PrimaryKeyJoinColumn( name = "ADDRESS_ID" ) )
public class Address
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = -7047593003649701467L;
    
    @Column( name = "CUSTOMER_ID", nullable = false, table = "TBL_CUSTOMER_ADDRESS" )
    private Long customerId;
    
    @Column( name = "CUSTOMER_ADDRESS_ID", nullable = false, table = "TBL_CUSTOMER_ADDRESS" )
    private Long customerAddressId;

    @Column( name = "ADDRESS_1", nullable = false, length = 128 )
    @NotNull( message = "Address 1 must not be empty" )
    @Size( min = 2, max = 128, message = "Address 1 must be between 2 and 128 characters long" )
    private String address1;

    @Column( name = "ADDRESS_2", nullable = true, length = 128 )
    @Size( min = 2, max = 128, message = "Address 2 must be between 2 and 128 characters long" )
    private String address2;

    @Column( name = "CITY", nullable = false, length = 128 )
    @NotNull
    @Size( min = 2, max = 128, message = "City must be between 2 and 128 characters long" )
    private String city;

    @Column( name = "STATE", nullable = false, length = 2 )
    @NotNull( message = "You must select a valid state" )
    @Enumerated( EnumType.STRING )
    private State state;

    @Column( name = "ZIP_CODE", nullable = false, length = 10 )
    @NotNull( message = "Zip code must not be empty" )
    @Size( min = 5, max = 10, message = "Zip code must be 5 or 10 digits long" )
    private String zipCode;
    
    @Column( name = "DEFAULT_ADDRESS", nullable = false, table = "TBL_CUSTOMER_ADDRESS" )
    private Boolean defaultAddress;

    public Address()
    {
    }

    public Address( String address1, String city, State state, String zipCode )
    {
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    @JsonIgnore
    public Long getCustomerId()
    {
        return customerId;
    }

    public void setCustomerId( Long customerId )
    {
        this.customerId = customerId;
    }

    @JsonIgnore
    public Long getCustomerAddressId()
    {
        return customerAddressId;
    }

    public void setCustomerAddressId( Long customerAddressId )
    {
        this.customerAddressId = customerAddressId;
    }

    public String getAddress1()
    {
        return address1;
    }

    public void setAddress1( String address1 )
    {
        this.address1 = address1;
    }

    public String getAddress2()
    {
        return address2;
    }

    public void setAddress2( String address2 )
    {
        this.address2 = address2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public State getState()
    {
        return state;
    }

    public void setState( State state )
    {
        this.state = state;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode( String zipCode )
    {
        this.zipCode = zipCode;
    }

    public Boolean isDefaultAddress()
    {
        return defaultAddress;
    }

    public void setDefaultAddress( Boolean defaultAddress )
    {
        this.defaultAddress = defaultAddress;
    }
    
}

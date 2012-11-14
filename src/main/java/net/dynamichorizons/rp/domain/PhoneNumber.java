package net.dynamichorizons.rp.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

@Entity
@Table( name = "TBL_PHONE" )
@AttributeOverride( name = "id", column = @Column( name = "PHONE_ID" ) )
public class PhoneNumber
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = 4618776134931688766L;

    @Column( name = "PHONE_NUMBER", nullable = false, length = 10 )
    @NotNull(message = "Phone number must not be empty")
    @Size( min = 10, max = 10, message = "Phone number must be 10 digits long" )
    private String phoneNumber;

    @Column( name = "PHONE_EXT", nullable = true, length = 5 )
    @Size( max = 5, message = "Phone extension must be less than 5 digits long" )
    private String phoneExt;

    @Column( name = "PHONE_DESC", nullable = true, length = 128 )
    @Size( max = 128, message = "Phone description must be between 2 and 128 characters long" )
    private String phoneDescription;

    public PhoneNumber()
    {
    }

    public PhoneNumber( String phoneNumber )
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber( String phoneNumber )
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneExt()
    {
        return phoneExt;
    }

    public void setPhoneExt( String phoneExt )
    {
        this.phoneExt = phoneExt;
    }

    public String getPhoneDescription()
    {
        return phoneDescription;
    }

    public void setPhoneDescription( String phoneDescription )
    {
        this.phoneDescription = phoneDescription;
    }
}

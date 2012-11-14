package net.dynamichorizons.rp.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;

@Entity
@Table( name = "TBL_USER" )
@AttributeOverride( name = "id", column = @Column( name = "USER_ID" ) )
public class User
    extends AbstractEntity<Long>
{
    private static final long serialVersionUID = 1221687814840578194L;

    @Column( name = "EMAIL", nullable = false, length = 255 )
    @NotNull(message = "Email address must not be empty")
    @Size( max = 255, message = "Email address must be less than 255 characters" )
    @Email(message = "Email address must be valid")
    private String emailAddress;

    @Column( name = "PASSWORD", nullable = false, length = 255 )
    private String dbPassword;

    @Size( min = 6, max = 16, message ="Password must be between 6 and 16 characters long" )
    @Transient
    private String password;

    @Column( name = "FIRST_NAME", nullable = false, length = 128 )
    @NotNull(message = "First name must not be empty")
    @Size( min = 2, max = 128, message = "First name must be between 2 and 128 characters long" )
    private String firstName;

    @Column( name = "LAST_NAME", nullable = false, length = 128 )
    @NotNull(message = "Last name must not be empty")
    @Size( min = 2, max = 128, message = "Last name must be between 2 and 128 characters long"  )
    private String lastName;

    @Column( name = "ACTIVE", nullable = false )
    private boolean active;

    public User()
    {
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress( String emailAddress )
    {
        this.emailAddress = emailAddress;
    }

    @JsonIgnore
    public String getDbPassword()
    {
        return dbPassword;
    }

    public void setDbPassword( String dbPassword )
    {
        this.dbPassword = dbPassword;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive( boolean active )
    {
        this.active = active;
    }
}

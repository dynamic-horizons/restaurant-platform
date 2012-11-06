package net.dynamichorizons.rp.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

@Entity
@Table( name = "TBL_USER" )
@AttributeOverride( name = "id", column = @Column( name = "USER_ID" ) )
public class User extends AbstractEntity<Long>
{
    private static final long serialVersionUID = 1221687814840578194L;

    @Column( name = "EMAIL", nullable = false, length = 255 )
    private String emailAddress;
    
    @Column( name = "PASSWORD", nullable = false, length = 255 )
    private String password;
    
    @Column( name = "FIRST_NAME", nullable = false, length = 128 )
    private String firstName;
    
    @Column( name = "LAST_NAME", nullable = false, length = 128 )
    private String lastName;
    
    @Column( name = "ACTIVE", nullable = false )
    private boolean active;
    
    public User() {
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress( String emailAddress )
    {
        this.emailAddress = emailAddress;
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

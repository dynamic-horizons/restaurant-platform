package net.dynamichorizons.rp.domain.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import net.dynamichorizons.rp.domain.user.User;

import org.joda.time.DateTime;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
public class AbstractEntity<PK extends Serializable>
    implements Persistable<PK>
{
    private static final long serialVersionUID = 1743597881995402609L;

    @Id
    @XmlAttribute( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private PK id;

    @XmlTransient
    @ManyToOne
    @JoinColumn( name = "CREATE_USER_ID" )
    private User createdBy;

    @XmlTransient
    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "CREATE_DATE", nullable = true )
    private Date createdDate;

    @XmlTransient
    @ManyToOne
    @JoinColumn( name = "MODIFY_USER_ID" )
    private User lastModifiedBy;

    @XmlTransient
    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "MODIFY_DATE", nullable = true )
    private Date lastModifiedDate;

    @XmlTransient
    @Version
    @Column( name = "OPTLOCK" )
    protected Integer version;

    public PK getId()
    {
        return id;
    }

    protected void setId( final PK id )
    {
        this.id = id;
    }

    public User getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy( User createdBy )
    {
        this.createdBy = createdBy;
    }

    public DateTime getCreatedDate()
    {
        return null == createdDate ? null : new DateTime( createdDate );
    }

    public void setCreatedDate( DateTime createdDate )
    {
        this.createdDate = null == createdDate ? null : createdDate.toDate();
    }

    public User getLastModifiedBy()
    {
        return lastModifiedBy;
    }

    public void setLastModifiedBy( User lastModifiedBy )
    {
        this.lastModifiedBy = lastModifiedBy;
    }

    public DateTime getLastModifiedDate()
    {
        return null == lastModifiedDate ? null : new DateTime( lastModifiedDate );
    }

    public void setLastModifiedDate( DateTime lastModifiedDate )
    {
        this.lastModifiedDate = null == lastModifiedDate ? null : lastModifiedDate.toDate();
    }
    
    public Integer getVersion()
    {
        return version;
    }

    public void setVersion( Integer version )
    {
        this.version = version;
    }

    public boolean isNew()
    {
        return null == getId();
    }

    @Override
    public String toString()
    {
        return String.format( "Entity of type %s with id: %s", this.getClass().getName(), getId() );
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( null == obj )
        {
            return false;
        }

        if ( this == obj )
        {
            return true;
        }

        if ( !getClass().equals( obj.getClass() ) )
        {
            return false;
        }

        AbstractEntity<?> that = (AbstractEntity<?>) obj;

        return null == this.getId() ? false : this.getId().equals( that.getId() );
    }

    @Override
    public int hashCode()
    {
        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }

}

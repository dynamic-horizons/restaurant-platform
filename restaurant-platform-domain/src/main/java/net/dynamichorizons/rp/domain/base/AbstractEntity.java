package net.dynamichorizons.rp.domain.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import net.dynamichorizons.rp.domain.User;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners( value = { AuditingEntityListener.class } )
public class AbstractEntity<PK extends Serializable>
    implements Auditable<User, PK>, Cloneable
{
    private static final long serialVersionUID = 1743597881995402609L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private PK id;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "CREATE_USER_ID", referencedColumnName = "USER_ID", nullable = false )
    @JsonIgnore
    private User createdBy;

    @Column( name = "CREATE_DATE" )
    @JsonIgnore
    private Date createdDate;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "MODIFY_USER_ID", referencedColumnName = "USER_ID", nullable = true )
    @JsonIgnore
    private User lastModifiedBy;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "MODIFY_DATE", nullable = true )
    @JsonIgnore
    private Date lastModifiedDate;

    @Version
    @Column( name = "OPTLOCK" )
    @JsonIgnore
    protected Integer version;

    @Override
    public PK getId()
    {
        return id;
    }

    protected void setId( final PK id )
    {
        this.id = id;
    }

    @Override
    @JsonIgnore
    public User getCreatedBy()
    {
        return createdBy;
    }

    @Override
    public void setCreatedBy( User createdBy )
    {
        this.createdBy = createdBy;
    }

    @Override
    @JsonIgnore
    public DateTime getCreatedDate()
    {
        return null == createdDate ? null : new DateTime( createdDate );
    }

    @Override
    public void setCreatedDate( DateTime createdDate )
    {
        this.createdDate = null == createdDate ? null : createdDate.toDate();
    }

    @Override
    @JsonIgnore
    public User getLastModifiedBy()
    {
        return lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy( User lastModifiedBy )
    {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    @JsonIgnore
    public DateTime getLastModifiedDate()
    {
        return null == lastModifiedDate ? null : new DateTime( lastModifiedDate );
    }

    @Override
    public void setLastModifiedDate( DateTime lastModifiedDate )
    {
        this.lastModifiedDate = null == lastModifiedDate ? null : lastModifiedDate.toDate();
    }

    @JsonIgnore
    public Integer getVersion()
    {
        return version;
    }

    public void setVersion( Integer version )
    {
        this.version = version;
    }

    @Override
    @JsonIgnore
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

    @SuppressWarnings( "unchecked" )
    @Override
    public AbstractEntity<PK> clone()
        throws CloneNotSupportedException
    {
        return (AbstractEntity<PK>) super.clone();
    }

}

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
    implements Auditable<User, PK>
{
    private static final long serialVersionUID = 1743597881995402609L;

    @Id
    // @XmlAttribute( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private PK id;

    // @XmlTransient
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn( name = "CREATE_USER_ID" )
    private User createdBy;

    // @XmlTransient
    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "CREATE_DATE", nullable = true )
    private Date createdDate;

    // @XmlTransient
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn( name = "MODIFY_USER_ID" )
    private User lastModifiedBy;

    // @XmlTransient
    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "MODIFY_DATE", nullable = true )
    private Date lastModifiedDate;

    // @XmlTransient
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

    @JsonIgnore
    public User getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy( User createdBy )
    {
        this.createdBy = createdBy;
    }

    @JsonIgnore
    public DateTime getCreatedDate()
    {
        return null == createdDate ? null : new DateTime( createdDate );
    }

    public void setCreatedDate( DateTime createdDate )
    {
        this.createdDate = null == createdDate ? null : createdDate.toDate();
    }

    @JsonIgnore
    public User getLastModifiedBy()
    {
        return lastModifiedBy;
    }

    public void setLastModifiedBy( User lastModifiedBy )
    {
        this.lastModifiedBy = lastModifiedBy;
    }

    @JsonIgnore
    public DateTime getLastModifiedDate()
    {
        return null == lastModifiedDate ? null : new DateTime( lastModifiedDate );
    }

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

}

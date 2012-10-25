package net.dynamichorizons.rp.domain.user;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

@XmlRootElement( name = "user" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "User", propOrder = {  } )
@Entity
@Table( name = "TBL_USER" )
@AttributeOverride( name = "id", column = @Column( name = "USER_ID" ) )
public class User extends AbstractEntity<Long>
{
    private static final long serialVersionUID = 1221687814840578194L;

}

package net.dynamichorizons.rp.domain.order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import net.dynamichorizons.rp.domain.base.AbstractEntity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@XmlRootElement( name = "order" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Order", propOrder = { "orderMenuSelections" } )
@Entity
@Table( name = "TBL_ORDER" )
@AttributeOverride( name = "id", column = @Column( name = "ORDER_ID" ) )
public class Order
    extends AbstractEntity<Long>
{

    private static final long serialVersionUID = 5634299855367051238L;
    
    @XmlElementWrapper( name = "order_selections", required = true )
    @XmlElement( name = "order_selection" )
    @OneToMany( mappedBy = "parentOrder", fetch = FetchType.EAGER )
    @Fetch( value = FetchMode.SELECT )
    private List<OrderMenuSelection> orderMenuSelections;

    public Order()
    {
    }

    public List<OrderMenuSelection> getOrderMenuSelections()
    {
        if ( orderMenuSelections == null )
        {
            orderMenuSelections = new ArrayList<OrderMenuSelection>();
        }
        return orderMenuSelections;
    }

    public void addOrderMenuSelection( OrderMenuSelection orderMenuSelection )
    {
        getOrderMenuSelections().add( orderMenuSelection );
    }

    public void setOrderMenuSelections( List<OrderMenuSelection> orderMenuSelections )
    {
        this.orderMenuSelections = orderMenuSelections;
    }

}

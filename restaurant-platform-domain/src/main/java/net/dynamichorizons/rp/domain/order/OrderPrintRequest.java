package net.dynamichorizons.rp.domain.order;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;

public class OrderPrintRequest
    implements Serializable
{

    private static final long serialVersionUID = 8904102960257210268L;

    private OrderPrintRequestType orderPrintRequestType;

    private Date printDate;

    public OrderPrintRequestType getOrderPrintRequestType()
    {
        return orderPrintRequestType;
    }

    public void setOrderPrintRequestType( OrderPrintRequestType orderPrintRequestType )
    {
        this.orderPrintRequestType = orderPrintRequestType;
    }

    public boolean isPrintRequest()
    {
        return OrderPrintRequestType.REQUEST.equals( orderPrintRequestType );
    }

    public boolean isPrintUpdate()
    {
        return OrderPrintRequestType.UPDATE.equals( orderPrintRequestType ) && getPrintDate() != null;
    }

    public DateTime getPrintDate()
    {
        return null == printDate ? null : new DateTime( printDate );
    }

    @JsonIgnore
    public Date getPrintDateAsDate()
    {
        return printDate;
    }

    public String getPrintDateAsString()
    {
        return getPrintDate().toString( "MM/dd/yyyy hh:mm a" );
    }

    public void setPrintDate( DateTime printDate )
    {
        this.printDate = null == printDate ? null : printDate.toDate();
    }

}

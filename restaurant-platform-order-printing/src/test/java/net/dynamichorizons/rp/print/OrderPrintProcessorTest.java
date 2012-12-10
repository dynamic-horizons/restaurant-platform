package net.dynamichorizons.rp.print;

import net.dynamichorizons.rp.domain.State;
import net.dynamichorizons.rp.domain.User;
import net.dynamichorizons.rp.domain.customer.Address;
import net.dynamichorizons.rp.domain.customer.Customer;
import net.dynamichorizons.rp.domain.customer.PhoneNumber;
import net.dynamichorizons.rp.domain.menu.MenuItem;
import net.dynamichorizons.rp.domain.menu.MenuItemSize;
import net.dynamichorizons.rp.domain.order.Order;
import net.dynamichorizons.rp.domain.order.OrderMenuSelection;
import net.dynamichorizons.rp.domain.order.OrderStatus;
import net.dynamichorizons.rp.domain.order.OrderType;

import org.joda.time.DateTime;
import org.junit.Test;

public class OrderPrintProcessorTest
{
    private OrderPrintProcessor orderPrintProcessor;

    private static final double MPLS_SALES_TAX = 0.07775;

    public OrderPrintProcessorTest()
        throws Exception
    {
        orderPrintProcessor = new OrderPrintProcessor();
    }

    @Test
    public void testOn()
        throws Exception
    {
        Order testOrder = new Order();

        testOrder.setOrderStatus( OrderStatus.COMPLETED );
        testOrder.setOrderType( OrderType.COURIER );

        testOrder.setOrderDate( new DateTime() );

        testOrder.setCustomer( getCustomer() );
        testOrder.setBillingAddress( getAddress() );
        testOrder.setDeliveryAddress( getAddress() );
        testOrder.setCustomerPhoneNumber( getPhone() );

        testOrder.setIsAsapOrder( true );
        testOrder.setDeliveryCharge( 15D );

        testOrder.addOrderMenuSelection( getOrderMenuSelection( "Test 1", 10.54, 2 ) );
        testOrder.addOrderMenuSelection( getOrderMenuSelectionSize( "Test 2", 8.54, 2 ) );
        testOrder.addOrderMenuSelection( getOrderMenuSelection( "Test 3", 6.54, 5 ) );
        testOrder.addOrderMenuSelection( getOrderMenuSelection( "Test 4", 5.54, 3 ) );
        testOrder.addOrderMenuSelection( getOrderMenuSelectionSize( "Test 5", 7.54, 5 ) );
        testOrder.addOrderMenuSelection( getOrderMenuSelectionSize( "Test 6", 10.54, 3 ) );

        setTotalsAndTax( testOrder );

        orderPrintProcessor.printOrder( testOrder );
    }

    private OrderMenuSelection getOrderMenuSelection( String menuName, Double price, Integer quantity )
    {
        OrderMenuSelection orderMenuSelection = new OrderMenuSelection();

        MenuItem menuItem = new MenuItem();
        menuItem.setMenuItemName( menuName );
        menuItem.setMenuItemPrice( price );

        orderMenuSelection.setSelectedMenuItem( menuItem );

        Double total = null;

        total = price * quantity;

        orderMenuSelection.setQuantity( quantity );
        orderMenuSelection.setPrice( price );
        orderMenuSelection.setTotal( total );

        return orderMenuSelection;
    }

    private OrderMenuSelection getOrderMenuSelectionSize( String menuName, Double price, Integer quantity )
    {
        OrderMenuSelection orderMenuSelection = new OrderMenuSelection();

        MenuItem menuItem = new MenuItem();
        menuItem.setMenuItemName( menuName );
        menuItem.setMenuItemPrice( null );

        orderMenuSelection.setSelectedMenuItem( menuItem );

        MenuItemSize menuItemSize = new MenuItemSize();
        menuItemSize.setMenuItemSizeName( "TEST TEST" );
        orderMenuSelection.setSelectedMenuItemSize( menuItemSize );

        Double total = null;

        total = price * quantity;

        orderMenuSelection.setQuantity( quantity );
        orderMenuSelection.setPrice( price );
        orderMenuSelection.setTotal( total );

        return orderMenuSelection;
    }

    private Customer getCustomer()
    {
        Customer customer = new Customer();
        User user = new User();
        user.setFirstName( "Nate" );
        user.setLastName( "Steffan" );
        user.setEmailAddress( "nate@natesteffan.com" );

        customer.setUser( user );

        return customer;
    }

    private Address getAddress()
    {
        return new Address( "16917 Gannon Way W", "Rosemount", State.MN, "55068" );
    }

    private PhoneNumber getPhone()
    {
        return new PhoneNumber( "952-994-5399" );
    }

    private void setTotalsAndTax( Order currentOrder )
    {
        double subTotal = 0D;
        double total = 0D;
        double salesTax = 0D;

        for ( OrderMenuSelection orderMenuSelection : currentOrder.getOrderMenuSelections() )
        {
            subTotal += orderMenuSelection.getTotal();
        }

        currentOrder.setOrderSubTotal( subTotal );

        total = subTotal;

        if ( currentOrder.getDeliveryCharge() != null )
        {
            total += currentOrder.getDeliveryCharge();
        }

        // Calculate Tax - Hard coded for Minneapolis
        salesTax = total * MPLS_SALES_TAX;
        currentOrder.setSalesTax( salesTax );

        total += salesTax;
        currentOrder.setOrderTotal( total );
    }
}

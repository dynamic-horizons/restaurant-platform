package net.dynamichorizons.rp.service.order;

import javax.annotation.PreDestroy;

import net.dynamichorizons.rp.domain.customer.Address;
import net.dynamichorizons.rp.domain.customer.Customer;
import net.dynamichorizons.rp.domain.customer.PhoneNumber;
import net.dynamichorizons.rp.domain.exceptions.InvalidDataException;
import net.dynamichorizons.rp.domain.menu.MenuItem;
import net.dynamichorizons.rp.domain.menu.MenuItemSize;
import net.dynamichorizons.rp.domain.order.CreateOrderRequest;
import net.dynamichorizons.rp.domain.order.Order;
import net.dynamichorizons.rp.domain.order.OrderMenuSelection;
import net.dynamichorizons.rp.domain.order.OrderStatus;
import net.dynamichorizons.rp.domain.order.OrderType;
import net.dynamichorizons.rp.service.UserServiceImpl;
import net.dynamichorizons.rp.service.customer.CustomerService;
import net.dynamichorizons.rp.store.menu.MenuItemRepository;
import net.dynamichorizons.rp.store.menu.MenuItemSizeRepository;
import net.dynamichorizons.rp.store.order.OrderMenuSelectionRepository;
import net.dynamichorizons.rp.store.order.OrderRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope( value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES )
@Transactional( readOnly = true )
public class OrderServiceImpl
    implements OrderService
{

    private static final Logger LOG = LoggerFactory.getLogger( UserServiceImpl.class );

    private static final double MPLS_SALES_TAX = 0.07775;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMenuSelectionRepository orderMenuSelectionRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private MenuItemSizeRepository menuItemSizeRepository;

    @Autowired
    private OrderPrintingService orderPrintingService;

    private Order currentOrder = null;

    @Override
    public Order getCurrentOrder()
    {
        return currentOrder;
    }

    @Override
    @Transactional
    public Order createOrder( CreateOrderRequest createOrderRequest )
    {
        try
        {
            currentOrder = new Order();

            Customer customer = customerService.getCustomer();

            currentOrder.setCustomer( customer );

            System.out.println( "Order Type: " + createOrderRequest.getOrderType() );
            System.out.println( "Phone Number: " + createOrderRequest.getPhoneNumberKey() );
            System.out.println( "Billing Address: " + createOrderRequest.getBillingAddressKey() );
            System.out.println( "Delivery Address: " + createOrderRequest.getDeliveryAddressKey() );
            System.out.println( "Order Date / Time: " + createOrderRequest.getOrderDate() );
            System.out.println( "Is ASAP Order: " + createOrderRequest.isAsapOrder() );

            currentOrder.setOrderType( OrderType.fromOrderTypeKey( createOrderRequest.getOrderType() ) );
            currentOrder.setOrderStatus( OrderStatus.IN_PROCESS );
            currentOrder.setOrderDate( createOrderRequest.getOrderDate() );
            currentOrder.setIsAsapOrder( createOrderRequest.isAsapOrder() );

            for ( Address address : customer.getAddresses() )
            {
                if ( address.getId().equals( createOrderRequest.getBillingAddressKey() ) )
                {
                    currentOrder.setBillingAddress( address );
                }

                if ( address.getId().equals( createOrderRequest.getDeliveryAddressKey() ) )
                {
                    currentOrder.setDeliveryAddress( address );
                }
            }

            for ( PhoneNumber phoneNumber : customer.getPhoneNumbers() )
            {
                if ( phoneNumber.getId().equals( createOrderRequest.getPhoneNumberKey() ) )
                {
                    currentOrder.setCustomerPhoneNumber( phoneNumber );
                }
            }

            orderRepository.save( currentOrder );

        }
        catch ( Exception e )
        {
            currentOrder = null;

            throw e;
        }

        return currentOrder;
    }

    @Override
    @Transactional
    public Order getOrder( Long orderId )
    {
        return getOrderAndInjectOrderInfo( orderId );
    }

    @Override
    @Transactional
    public OrderMenuSelection addOrderMenuSelection( OrderMenuSelection orderMenuSelection )
        throws InvalidDataException
    {
        return setOrderMenuSelectionAttributes( orderMenuSelection, new OrderMenuSelection(), true );
    }

    @Override
    @Transactional
    public OrderMenuSelection modifyOrderMenuSelection( OrderMenuSelection orderMenuSelection )
        throws InvalidDataException
    {
        OrderMenuSelection currentMenuSelection = null;

        for ( OrderMenuSelection menuSelection : currentOrder.getOrderMenuSelections() )
        {
            if ( menuSelection.getId().equals( orderMenuSelection.getId() ) )
            {
                currentMenuSelection = menuSelection;
            }
        }

        if ( currentMenuSelection == null )
        {
            throw new InvalidDataException();
        }

        return setOrderMenuSelectionAttributes( orderMenuSelection, currentMenuSelection, false );
    }

    private OrderMenuSelection setOrderMenuSelectionAttributes( OrderMenuSelection request,
                                                                OrderMenuSelection newCurrent, boolean isNew )
    {
        MenuItem menuItem = null;
        MenuItemSize menuItemSize = null;
        Double price = null;
        Double total = null;

        // Set Order
        if ( isNew )
        {
            newCurrent.setOrder( currentOrder );
        }

        // Set MenuItem
        if ( request.getSelectedMenuItem() != null && request.getSelectedMenuItem().getId() != null )
        {
            if ( isNew )
            {
                newCurrent.setMenuGroupItemId( request.getSelectedMenuItem().getMenuGroupItemId() );
            }

            menuItem = menuItemRepository.findByMenuGroupItemId( newCurrent.getMenuGroupItemId() );
        }
        else
        {
            throw new InvalidDataException();
        }

        // Set MenuItemSize
        if ( request.getSelectedMenuItemSize() != null && request.getSelectedMenuItemSize().getId() != null )
        {
            newCurrent.setMenuItemSizeId( request.getSelectedMenuItemSize().getId() );

            menuItemSize = menuItemSizeRepository.findOne( newCurrent.getMenuItemSizeId() );
        }
        else
        {
            newCurrent.setMenuItemSizeId( null );
        }

        // Set Quantity
        if ( newCurrent.getQuantity() == null )
        {
            newCurrent.setQuantity( 1 );
        }
        newCurrent.setQuantity( request.getQuantity() );

        // Set Comments
        newCurrent.setComments( request.getComments() );

        // Build Pricing Information
        if ( menuItem.getMenuItemPrice() != null )
        {
            price = menuItem.getMenuItemPrice();
        }
        else if ( menuItemSize != null && menuItemSize.getMenuItemSizePrice() != null )
        {
            price = menuItemSize.getMenuItemSizePrice();
        }
        else
        {
            throw new InvalidDataException();
        }

        total = price * newCurrent.getQuantity();

        newCurrent.setPrice( price );
        newCurrent.setTotal( total );

        orderMenuSelectionRepository.save( newCurrent );

        currentOrder = getOrderAndInjectOrderInfo( currentOrder.getId() );

        // Set The Totals and Sales Tax
        setTotalsAndTax();
        orderRepository.save( currentOrder );

        return newCurrent;
    }

    @Override
    @Transactional
    public void removeMenuItem( Long orderMenuSelectionId )
    {
        OrderMenuSelection removedOrderMenuSelection = null;

        for ( OrderMenuSelection orderMenuSelection : currentOrder.getOrderMenuSelections() )
        {
            if ( orderMenuSelection.getId().equals( orderMenuSelectionId ) )
            {
                removedOrderMenuSelection = orderMenuSelection;
            }
        }

        if ( removedOrderMenuSelection != null )
        {
            currentOrder.getOrderMenuSelections().remove( removedOrderMenuSelection );
            orderMenuSelectionRepository.delete( removedOrderMenuSelection );
        }
    }

    @Override
    @Transactional
    public void cancelCurrentOrder()
    {
        if ( currentOrder != null )
        {
            orderRepository.delete( currentOrder );
            currentOrder = null;
        }
    }

    private Order getOrderAndInjectOrderInfo( Long orderId )
    {
        Order order = orderRepository.findOne( orderId );

        if ( order == null )
        {
            return null;
        }

        for ( OrderMenuSelection orderMenuSelection : order.getOrderMenuSelections() )
        {
            orderMenuSelection.setSelectedMenuItem( menuItemRepository.findByMenuGroupItemId( orderMenuSelection.getMenuGroupItemId() ) );

            if ( orderMenuSelection.getMenuItemSizeId() != null )
            {
                orderMenuSelection.setSelectedMenuItemSize( menuItemSizeRepository.findOne( orderMenuSelection.getMenuItemSizeId() ) );
            }
        }

        return order;
    }

    private void setTotalsAndTax()
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

    @PreDestroy
    private void cleanup()
    {
        LOG.info( "Destroy::OrderServiceImpl" );
        cancelCurrentOrder();
    }

}

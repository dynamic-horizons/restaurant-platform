package net.dynamichorizons.rp.service.order;

import net.dynamichorizons.rp.domain.customer.Address;
import net.dynamichorizons.rp.domain.customer.Customer;
import net.dynamichorizons.rp.domain.customer.PhoneNumber;
import net.dynamichorizons.rp.domain.exceptions.InvalidDataException;
import net.dynamichorizons.rp.domain.menu.MenuItem;
import net.dynamichorizons.rp.domain.menu.MenuItemSize;
import net.dynamichorizons.rp.domain.order.AddOrderMenuSelectionRequest;
import net.dynamichorizons.rp.domain.order.CreateOrderRequest;
import net.dynamichorizons.rp.domain.order.Order;
import net.dynamichorizons.rp.domain.order.OrderMenuSelection;
import net.dynamichorizons.rp.domain.order.OrderType;
import net.dynamichorizons.rp.service.customer.CustomerService;
import net.dynamichorizons.rp.store.menu.MenuItemRepository;
import net.dynamichorizons.rp.store.menu.MenuItemSizeRepository;
import net.dynamichorizons.rp.store.order.OrderMenuSelectionRepository;
import net.dynamichorizons.rp.store.order.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope( value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES )
public class OrderServiceImpl
    implements OrderService
{

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

    private Order currentOrder = null;

    @Override
    public Order getCurrentOrder()
    {
        return currentOrder;
    }

    @Override
    public Order createOrder( CreateOrderRequest createOrderRequest )
    {
        currentOrder = new Order();

        Customer customer = customerService.getCustomer();

        currentOrder.setCustomer( customer );

        // TODO Set Order Type

        OrderType orderType = OrderType.fromOrderKey( createOrderRequest.getOrderType() );

        // TODO Set Delivery Date / Time

        for ( Address address : customer.getAddresses() )
        {
            if ( address.getId().equals( createOrderRequest.getOrderAddressKey() ) )
            {
                currentOrder.setOrderAddress( address );
            }

            if ( address.getId().equals( createOrderRequest.getDeliveryAddressKey() ) )
            {
                currentOrder.setDeliveryAddress( address );
            }
        }

        // TODO Set Phone Number
        for ( PhoneNumber phone : customer.getPhoneNumbers() )
        {
            if ( phone.getId().equals( createOrderRequest.getPhoneNumberKey() ) )
            {
                // currentOrder.set
            }
        }

        orderRepository.save( currentOrder );

        return currentOrder;
    }

    @Override
    public Order addMenuItem( AddOrderMenuSelectionRequest orderMenuSelectionRequest )
        throws InvalidDataException
    {
        MenuItem menuItem = menuItemRepository.findOne( orderMenuSelectionRequest.getMenuItemId() );
        MenuItemSize menuItemSize = null;

        if ( menuItem == null )
        {
            throw new InvalidDataException();
        }

        if ( orderMenuSelectionRequest.getMenuItemSizeId() != null )
        {
            menuItemSize = menuItemSizeRepository.findOne( orderMenuSelectionRequest.getMenuItemSizeId() );

            if ( menuItemSize == null )
            {
                throw new InvalidDataException();
            }
        }

        OrderMenuSelection orderMenuSelection = new OrderMenuSelection();
        orderMenuSelection.setOrder( currentOrder );
        orderMenuSelection.setSelectedMenuItem( menuItem );
        orderMenuSelection.setSelectedMenuItemSize( menuItemSize );
        orderMenuSelection.setOrderMenuSelectionComments( orderMenuSelectionRequest.getComments() );

        currentOrder.addOrderMenuSelection( orderMenuSelection );

        orderRepository.save( currentOrder );

        return currentOrder;
    }

    @Override
    public Order removeMenuItem( Long orderMenuSelectionId )
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

        return currentOrder;
    }

    @Override
    public void cancelCurrentOrder()
    {
        orderRepository.delete( currentOrder );

        currentOrder = null;
    }

}

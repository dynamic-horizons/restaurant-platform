/**
 * Copyright (C) 2012 Dynamic Horizons, LLC <https://www.dynamichorizons.net>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 *   
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package net.dynamichorizons.rp.domain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import net.dynamichorizons.rp.domain.menu.Menu;
import net.dynamichorizons.rp.domain.menu.MenuDuration;
import net.dynamichorizons.rp.domain.menu.MenuGroup;
import net.dynamichorizons.rp.domain.menu.MenuGroupOption;
import net.dynamichorizons.rp.domain.menu.MenuGroupOptionItem;
import net.dynamichorizons.rp.domain.menu.MenuItem;
import net.dynamichorizons.rp.domain.menu.MenuItemAllergyInformation;
import net.dynamichorizons.rp.domain.menu.MenuItemImage;
import net.dynamichorizons.rp.domain.menu.MenuItemOption;
import net.dynamichorizons.rp.domain.menu.MenuItemOptionItem;
import net.dynamichorizons.rp.domain.menu.MenuItemSize;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * net.dynamichorizons.rp.domain.menu package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content.
 * The Java representation of XML content can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory methods for each of these are provided in
 * this class.
 */
@XmlRegistry
public class ObjectFactory
{

    private final static QName _Omf_QNAME = new QName( "http://openmenu.org/schema", "omf" );

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
     * net.dynamichorizons.rp.domain.menu
     */
    public ObjectFactory()
    {
    }

    /**
     * Create an instance of {@link MenuGroupOption }
     */
    public MenuGroupOption createMenuGroupOption()
    {
        return new MenuGroupOption();
    }

    /**
     * Create an instance of {@link RestaurantInfo }
     */
    public RestaurantInfo createRestaurantInfo()
    {
        return new RestaurantInfo();
    }

    /**
     * Create an instance of {@link MenuItem }
     */
    public MenuItem createMenuItem()
    {
        return new MenuItem();
    }

    /**
     * Create an instance of {@link MenuGroup }
     */
    public MenuGroup createMenuGroup()
    {
        return new MenuGroup();
    }

    /**
     * Create an instance of {@link Menu }
     */
    public Menu createMenu()
    {
        return new Menu();
    }

    /**
     * Create an instance of {@link Environment }
     */
    public Environment createEnvironment()
    {
        return new Environment();
    }

    /**
     * Create an instance of {@link OpenMenuFormat }
     */
    public OpenMenuFormat createOpenMenuFormat()
    {
        return new OpenMenuFormat();
    }

    /**
     * Create an instance of {@link ImageType }
     */
    public ImageType createImageType()
    {
        return new ImageType();
    }

    /**
     * Create an instance of {@link MenuDuration }
     */
    public MenuDuration createMenuDuration()
    {
        return new MenuDuration();
    }

    /**
     * Create an instance of {@link DeliveryAvailable }
     */
    public DeliveryAvailable createDeliveryAvailable()
    {
        return new DeliveryAvailable();
    }

    /**
     * Create an instance of {@link OpenMenu }
     */
    public OpenMenu createOpenMenu()
    {
        return new OpenMenu();
    }

    /**
     * Create an instance of {@link Region }
     */
    public Region createRegion()
    {
        return new Region();
    }

    /**
     * Create an instance of {@link Contacts }
     */
    public Contacts createContacts()
    {
        return new Contacts();
    }

    /**
     * Create an instance of {@link MenuItemImage }
     */
    public MenuItemImage createMenuItemImageUrl()
    {
        return new MenuItemImage();
    }

    /**
     * Create an instance of {@link MenuItemSize }
     */
    public MenuItemSize createMenuItemSize()
    {
        return new MenuItemSize();
    }

    /**
     * Create an instance of {@link OnlineOrdering }
     */
    public OnlineOrdering createOnlineOrdering()
    {
        return new OnlineOrdering();
    }

    /**
     * Create an instance of {@link MenuItemOption }
     */
    public MenuItemOption createMenuItemOption()
    {
        return new MenuItemOption();
    }

    /**
     * Create an instance of {@link ParentCompany }
     */
    public ParentCompany createParentCompany()
    {
        return new ParentCompany();
    }

    /**
     * Create an instance of {@link Contact }
     */
    public Contact createContact()
    {
        return new Contact();
    }

    /**
     * Create an instance of {@link OperatingDay }
     */
    public OperatingDay createOperatingDay()
    {
        return new OperatingDay();
    }

    /**
     * Create an instance of {@link MenuItemOptionItem }
     */
    public MenuItemOptionItem createMenuItemOptionItem()
    {
        return new MenuItemOptionItem();
    }

    /**
     * Create an instance of {@link MenuGroupOptionItem }
     */
    public MenuGroupOptionItem createMenuGroupOptionItem()
    {
        return new MenuGroupOptionItem();
    }

    /**
     * Create an instance of {@link OnlineReservation }
     */
    public OnlineReservation createOnlineReservation()
    {
        return new OnlineReservation();
    }

    /**
     * Create an instance of {@link Crosswalks }
     */
    public Crosswalks createCrosswalks()
    {
        return new Crosswalks();
    }

    /**
     * Create an instance of {@link MenuItem.MenuItemAllergyInformation }
     */
    public MenuItemAllergyInformation createMenuItemMenuItemAllergyInformation()
    {
        return new MenuItemAllergyInformation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenMenuFormat }{@code >}
     */
    @XmlElementDecl( namespace = "http://openmenu.org/schema", name = "omf" )
    public JAXBElement<OpenMenuFormat> createOmf( OpenMenuFormat value )
    {
        return new JAXBElement<OpenMenuFormat>( _Omf_QNAME, OpenMenuFormat.class, null, value );
    }

}

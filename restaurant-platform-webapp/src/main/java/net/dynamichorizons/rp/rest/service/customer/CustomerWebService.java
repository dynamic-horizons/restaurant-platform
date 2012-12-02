package net.dynamichorizons.rp.rest.service.customer;

import net.dynamichorizons.rp.domain.customer.Customer;

public interface CustomerWebService
{

    public Customer getCustomer();

    public Customer registerCustomer( Customer customer );

}

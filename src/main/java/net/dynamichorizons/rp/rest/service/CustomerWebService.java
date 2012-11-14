package net.dynamichorizons.rp.rest.service;

import net.dynamichorizons.rp.domain.Customer;

public interface CustomerWebService
{

    public Customer getCustomer();

    public Customer registerCustomer( Customer customer );

}

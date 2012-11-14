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
package net.dynamichorizons.rp.rest.service;

import net.dynamichorizons.rp.domain.Customer;
import net.dynamichorizons.rp.domain.LoginToken;
import net.dynamichorizons.rp.domain.exceptions.LoginException;

public interface RestaurantWebService
{
    public String defaultService();

    public String buildInformation();
    
    public Customer login( LoginToken loginToken )
                    throws LoginException;

    public String logout();
}

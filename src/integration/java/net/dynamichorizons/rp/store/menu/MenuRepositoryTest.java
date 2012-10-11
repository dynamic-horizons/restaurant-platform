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
package net.dynamichorizons.rp.store.menu;

import java.util.Iterator;

import net.dynamichorizons.rp.domain.menu.Menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration( locations = { "file:**/WEB-INF/application-context-test.xml" } )
@RunWith( SpringJUnit4ClassRunner.class )
@TransactionConfiguration( transactionManager = "transactionManager", defaultRollback = true )
@Transactional
public class MenuRepositoryTest
{
    Logger logger = LoggerFactory.getLogger( MenuRepositoryTest.class );

    @Autowired
    private MenuRepository menuRepository;

    @Test
    public void test()
    {
        try
        {
            Iterator<Menu> menuIterator = menuRepository.findAll().iterator();
            while(menuIterator.hasNext()){
                logger.info( menuIterator.next().toString() );
            }
        }
        catch ( Exception e )
        {
            logger.info( "Exception", e );
        }

    }
}

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
package net.dynamichorizons.rp.service;

import java.io.FileOutputStream;
import java.io.IOException;

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

@ContextConfiguration( locations = { "classpath:application-context-test.xml" } )
@RunWith( SpringJUnit4ClassRunner.class )
@TransactionConfiguration( transactionManager = "transactionManager", defaultRollback = true )
@Transactional
public class MenuDownloadServiceTest
{
    private static Logger logger = LoggerFactory.getLogger( MenuDownloadServiceTest.class );

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuDownloadService menuDownloadService;

    @Test
    public void test()
    {
        final Menu result = menuService.getMenuByMenuKey( "lunch" );

        if ( result != null )
        {
            FileOutputStream outputStream = null;
            try
            {
                outputStream = new FileOutputStream( "C:\\Development\\Test.pdf" );
                menuDownloadService.generateMenu( result, outputStream );
            }
            catch ( Exception e )
            {
                logger.error( "ERROR", e );
            }
            finally
            {
                try
                {
                    outputStream.close();
                }
                catch ( IOException e )
                {
                    logger.error( "ERROR", e );
                }
            }
        }
    }

}

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

@ContextConfiguration( locations = { "file:**/WEB-INF/application-context-test.xml" } )
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

package net.dynamichorizons.rp.service;

import net.dynamichorizons.rp.audit.DefaultAuditorAware;
import net.dynamichorizons.rp.domain.User;
import net.dynamichorizons.rp.domain.exceptions.DatabaseException;
import net.dynamichorizons.rp.domain.exceptions.LoginException;
import net.dynamichorizons.rp.domain.exceptions.UserExistsException;
import net.dynamichorizons.rp.store.UserRepository;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope( value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES )
public class UserServiceImpl
    implements UserService, DefaultAuditorAware
{
    private static final int HASH_ITERATIONS = 20480;

    private static final String SYSTEM_USER = "SYSTEM";

    private User currentUser;

    private User defaultSystemUser;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser()
    {
        if(currentUser != null &&  SecurityUtils.getSubject().isAuthenticated()) {
            return currentUser;
        } else if(currentUser != null) {
            currentUser = null;
        }
        
        return null;
    }

    @Override
    public User login( String username, String password, boolean rememberMe )
        throws LoginException
    {
        Subject currentUserSubject = SecurityUtils.getSubject();

        if ( !currentUserSubject.isAuthenticated() )
        {
            UsernamePasswordToken token = new UsernamePasswordToken( username, password );
            token.setRememberMe( rememberMe );

            try
            {
                currentUserSubject.login( token );
            }
            catch ( AuthenticationException ae )
            {
                throw new LoginException();
            }
        }

        currentUser = userRepository.findByEmailAddress( username );

        return currentUser;
    }

    @Override
    public void logout()
    {
        Subject currentUserSubject = SecurityUtils.getSubject();
        if ( currentUserSubject.isAuthenticated() )
        {
            currentUserSubject.logout();
            currentUser = null;
        }
    }

    @Override
    public User getCurrentAuditor()
    {
        if ( currentUser != null )
        {
            return currentUser;
        }
        else if ( defaultSystemUser == null )
        {
            defaultSystemUser = userRepository.findByFirstNameAndLastName( SYSTEM_USER, SYSTEM_USER );
        }

        return defaultSystemUser;
    }

    @Override
    public User createUser( User user )
        throws UserExistsException, DatabaseException
    {
        if ( userRepository.findByEmailAddress( user.getEmailAddress() ) != null )
        {
            throw new UserExistsException();
        }

        if ( user.isNew() )
        {
            String hash = new Sha512Hash( user.getPassword(), getSalt(), HASH_ITERATIONS ).toBase64();
            user.setDbPassword( hash );
            user.setActive( true );
        }

        try
        {
            userRepository.save( user );
        }
        catch ( Exception e )
        {
            throw new DatabaseException( e );
        }

        Subject currentUserSubject = SecurityUtils.getSubject();

        if ( !currentUserSubject.isAuthenticated() )
        {
            UsernamePasswordToken token = new UsernamePasswordToken( user.getEmailAddress(), user.getPassword() );
            token.setRememberMe( false );

            try
            {
                currentUserSubject.login( token );
            }
            catch ( AuthenticationException ae )
            {
                throw new LoginException();
            }
        }

        return currentUser = user;
    }

    private ByteSource getSalt()
    {
        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
        return rng.nextBytes();
    }
}

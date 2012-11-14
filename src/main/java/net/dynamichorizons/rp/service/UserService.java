package net.dynamichorizons.rp.service;

import net.dynamichorizons.rp.domain.User;
import net.dynamichorizons.rp.domain.exceptions.DatabaseException;
import net.dynamichorizons.rp.domain.exceptions.LoginException;
import net.dynamichorizons.rp.domain.exceptions.UserExistsException;

public interface UserService
{

    public User getUser();
    
    public User login( String username, String password, boolean rememberMe )
        throws LoginException;

    public User createUser( User user )
        throws UserExistsException, DatabaseException;

    public void logout();
}

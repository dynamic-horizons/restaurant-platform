package net.dynamichorizons.rp.auth;

import net.dynamichorizons.rp.domain.User;
import net.dynamichorizons.rp.store.UserRepository;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantPlatformRealmImpl extends AuthorizingRealm implements RestaurantPlatformRealm
{
    @Autowired
    private UserRepository userRepository;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo( PrincipalCollection principals )
    {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo( AuthenticationToken token )
        throws AuthenticationException
    {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }
        
        User user = userRepository.findByEmailAddress( username );
        if (user == null) {
            throw new AccountException("Invalid username.");
        }
        
        ByteSource salt = Sha512Hash.fromBase64String( user.getDbPassword() ).getSalt();
        
        SimpleAuthenticationInfo simpleAuthInfo = new SimpleAuthenticationInfo(username, upToken.getCredentials(), getName());
        simpleAuthInfo.setCredentialsSalt( salt );
        
        return simpleAuthInfo;
    }

}

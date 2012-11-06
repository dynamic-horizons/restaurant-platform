package net.dynamichorizons.rp.service;

import net.dynamichorizons.rp.domain.User;
import net.dynamichorizons.rp.store.UserRepository;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private static final int HASH_ITERATIONS = 20480;

    @Autowired
    private UserRepository userRepository;

    public User createUser( User user )
    {
        if ( user.isNew() )
        {
            String hash = new Sha512Hash( user.getPassword(), getSalt(), HASH_ITERATIONS ).toBase64();
            user.setPassword( hash );
        }

        userRepository.save( user );

        return user;
    }

    private ByteSource getSalt()
    {
        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
        return rng.nextBytes();
    }
}

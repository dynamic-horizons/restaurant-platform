package net.dynamichorizons.rp.audit;

import net.dynamichorizons.rp.domain.User;
import net.dynamichorizons.rp.store.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class DefaultAuditorAwareImpl implements DefaultAuditorAware
{
    
    private static final String SYSTEM_USER = "SYSTEM";
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User getCurrentAuditor()
    {
        return userRepository.findByFirstNameAndLastName( SYSTEM_USER, SYSTEM_USER );
    }   
}

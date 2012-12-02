package net.dynamichorizons.rp.store;

import net.dynamichorizons.rp.domain.User;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository
    extends PagingAndSortingRepository<User, Long>
{
    
    public User findByEmailAddress( String emailAddress );
    
    public User findByFirstNameAndLastName( String firstName, String lastName );
    
}

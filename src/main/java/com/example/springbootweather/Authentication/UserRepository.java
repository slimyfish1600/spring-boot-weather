/*package com.example.springbootweather.Authentication;

import com.example.springbootweather.Authentication.User;
import com.example.springbootweather.services.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public abstract class UserRepository {
    public User findUserByEmail(String firstname){
        User user = new User(firstname,"123456");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        return user;
    }

    public abstract UserDetailsService loadUserByUsername(String email) throws UsernameNotFoundException;
}

 */
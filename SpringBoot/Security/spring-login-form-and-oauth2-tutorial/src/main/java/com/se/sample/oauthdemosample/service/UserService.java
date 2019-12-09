package com.se.sample.oauthdemosample.service;


import com.se.sample.oauthdemosample.entities.User;
import com.se.sample.oauthdemosample.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User userFindByUsername = userRepo.findByUsername(username);
        //Остальные поиски

        if(userFindByUsername != null)
        {
            return userFindByUsername;
        }
        //Остальные проверки
        return null;
    }
}

package com.se.example.springloginformandoauth2tutorial.service;

import com.se.example.springloginformandoauth2tutorial.entities.User;
import com.se.example.springloginformandoauth2tutorial.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //TODO:
        User userFindByUsername = userRepo.findByUsername(username);
        User userFindByName = userRepo.findByEmail(username);
        User userFindByGoogleUsername = userRepo.findByGoogleUsername(username);
        User userFindByGoogleName = userRepo.findByGoogleName(username);

        if (userFindByUsername != null) {
            return buildUser(userFindByUsername);
        }

        if (userFindByName != null) {
            return buildUser(userFindByUsername);
        }

        if (userFindByGoogleUsername != null) {
            return buildUser(userFindByUsername);
        }

        if (userFindByGoogleName != null) {
            return buildUser(userFindByUsername);
        }

        return null;
    }

    private  org.springframework.security.core.userdetails.User buildUser(User user){
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}
package com.se.security.demo.user;

import com.se.security.demo.user.model.UserRepository;
import com.se.security.demo.user.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final String DEFAULT_ROLE = "ROLE_USER";
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public User register(User user) {
        setPasswordAndRole(user);
        return userRepository.save(user);
    }

    private void setPasswordAndRole(User user) {
        user.getUserCredentials()
                .setPassword(encoder.encode(user.getUserCredentials().getPassword()));
        user.getUserCredentials().setRole(DEFAULT_ROLE);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUserCredentialsUsername(username);
    }

}
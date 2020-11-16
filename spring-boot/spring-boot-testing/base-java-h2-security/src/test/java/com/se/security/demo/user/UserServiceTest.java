package com.se.security.demo.user;

import com.se.security.demo.user.model.User;
import com.se.security.demo.user.model.UserCredentials;
import com.se.security.demo.user.model.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private BCryptPasswordEncoder encoder;
    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService(userRepository, encoder);
    }

    @Test
    public void register() {
        User user = createTestUser();
        when(userRepository.save(user))
                .thenReturn(user);
        userService.register(user);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void findByUsername() {
        User user = createTestUser();
        when(userRepository.findByUserCredentialsUsername("user"))
                .thenReturn(Optional.of(user));
        userService.findByUsername("user");

        verify(userRepository, times(1)).findByUserCredentialsUsername("user");
    }

    private User createTestUser() {
        UserCredentials userCredentials = new UserCredentials("user", "password", "ROLE_USER");
        return new User(userCredentials);
    }
}
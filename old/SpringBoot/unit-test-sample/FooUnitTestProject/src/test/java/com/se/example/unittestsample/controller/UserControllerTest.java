package com.se.example.unittestsample.controller;

import com.se.example.unittestsample.dao.User;
import com.se.example.unittestsample.repository.UserRepository;
import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private UserRepository mUserRepository = Mockito.mock(UserRepository.class);

    @Test
    public void testGetUserById() throws NotFoundException {
        Long id = 1l;

        User u = new User();
        u.setId(id);
        u.setName("name");

        when(userRepository.findById(1l)).thenReturn(java.util.Optional.of(u));

        User user = userController.get(1L);

        verify(userRepository).findById(1l);

        assertEquals(1l, user.getId());
    }
}
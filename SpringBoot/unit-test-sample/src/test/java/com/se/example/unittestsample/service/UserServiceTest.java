package com.se.example.unittestsample.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private ExternalService externalService;


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService = new UserService();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveUser() throws Exception {
        Mockito.when(externalService.getUser(Mockito.anyObject())).thenReturn(new UserDto());
    //    Mockito.when(userRepository.save(Mockito.anyList())).thenReturn(new ArrayList<>());

        userService.saveUser("548791");
        Mockito.verify(userService, Mockito.times(1)).saveUser("548791");
    }

}
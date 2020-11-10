package com.se.example.unittestsample.service;

import com.se.example.unittestsample.dto.UserDto;
import com.se.example.unittestsample.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private ExternalService externalService;

// ???
//    @Mock
//    private UserRepository ;

    private UserRepository userRepository = Mockito.mock(UserRepository.class);


    @InjectMocks
    private UserService userService = new UserService();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveUser() throws Exception {
     //   Mockito.when(externalService.getUser(Mockito.anyObject())).thenReturn(new UserDto());
    //    Mockito.when(userRepository.save(Mockito.anyList())).thenReturn(new ArrayList<>());

     //   userService.saveUser("548791");
    //    Mockito.verify(userService, Mockito.times(1)).saveUser("548791");
    }

}
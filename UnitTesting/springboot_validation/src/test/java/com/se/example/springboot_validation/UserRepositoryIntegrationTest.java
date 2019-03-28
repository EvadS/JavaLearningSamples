package com.se.example.springboot_validation;

import com.se.example.springboot_validation.entities.User;
import com.se.example.springboot_validation.repository.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers() {
        userRepository.save(new User("myBob", "my.bob@domain.com"));
        List<User> users = (List<User>) userRepository.findAll();

        Assert.assertEquals(users.size(),1);
    }

    @After
    public void cleanUp() {
        userRepository.deleteAll();
    }


}
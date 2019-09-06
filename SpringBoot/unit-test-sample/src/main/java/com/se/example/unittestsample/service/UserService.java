package com.se.example.unittestsample.service;

import com.se.example.unittestsample.dao.User;
import com.se.example.unittestsample.dto.UserDto;
import com.se.example.unittestsample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private ExternalService externalService;

    public Iterable<User> findAll(){
        return  userRepository.findAll();
    }

    public void saveUser(String userId) {
        UserDto userDto = new UserDto("some name", 20);//externalService.getUser(userId);
        User user = convertToUserEntity(userDto);
        userRepository.save(user);
    }

    private User convertToUserEntity(UserDto userDto) {
        User user = new User();

        user.setAge(userDto.getAge());
        user.setName(userDto.getName());

        return  user;
    }

}

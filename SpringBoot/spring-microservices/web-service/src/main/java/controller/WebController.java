package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dto.User;
import service.EmailService;
import service.UserService;

@RestController
public class WebController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<String> sendEmail(@RequestBody User user) {
        userService.sendEmail(user);
        return new ResponseEntity<>("Email Successfully sent", HttpStatus.OK);
    }

    @RequestMapping(value = "/email/{toAddress}", method = RequestMethod.POST)
    public ResponseEntity<Void> sendEmail(@PathVariable String toAddress) {
        emailService.sendEmail(toAddress);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

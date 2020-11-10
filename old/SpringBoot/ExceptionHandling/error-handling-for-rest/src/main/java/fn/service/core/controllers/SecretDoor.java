package fn.service.core.controllers;


import fn.service.core.exception.CustomException;
import fn.service.core.exception.ResourceNotFoundException;
import fn.service.core.models.SecretDoorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/secret-door")
public class SecretDoor {

    @GetMapping
    public SecretDoorResponse secretDoorBouncer(@RequestParam String passcode) {
        return new SecretDoorResponse("See you at Strawberry Trail, near the Broken Castle Pass");
    }

    @GetMapping("/hi")
    public String sayHi(@Validated @Size(max = 10, message = "name should at most 10 characters long")
                            @RequestParam("name") String name) {
        return "Hi " + name;
    }

    @GetMapping("/valid-name/{name}")
    public String createUsername(@PathVariable("name") @NotBlank @Size(max = 10) String username) {
        // ...
        return "Hi " + username;
    }

    @GetMapping("/exception")
    public SecretDoorResponse secretDoorBouncer2(@RequestParam String passcode) throws Exception {
        if (!passcode.equals("mango")) {
            throw new Exception("Wrong passcode!");
        }
        return new SecretDoorResponse("See you at Strawberry Trail, near the Broken Castle Pass");
    }

    @GetMapping("/custom-exception")
    public SecretDoorResponse secretDoorBouncer3(@RequestParam String passcode) {
        if (!passcode.equals("mango")) {
            throw new CustomException(
                    "Wrong passcode",
                    "You've entered an incorrect passcode, try again with correct one",
                    "Orange, juicy and sweet",
                    "Ask your friends for access at http://wwww.letmeinthesecretdoor.com",
                    "Reach out to http://wwww.letmeinthesecretdoor.com/support for more help");
        }
        return new SecretDoorResponse("See you at Strawberry Trail, near the Broken Castle Pass");
    }

    @GetMapping("/resource-not-found-exception")
    public ResponseEntity<String> throwNotFoundException() throws ResourceNotFoundException {
        throw new ResourceNotFoundException("Employee not found for this id :: " + "SOME PARAMETERS ");
    }

    @GetMapping("/throw-exception")
    public ResponseEntity<String> throwException() throws Exception {
        throw new Exception("SOME EXCEPTION MESSAGE");
    }

    @GetMapping(value = "/{id}")
    public String findById(@PathVariable("id") Long id, HttpServletResponse response) {
 //       try {
//            Foo resourceById = RestPreconditions.checkFound(service.findOne(id));
//
//            eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, response));
//            return resourceById;
//        }
//        catch (MyResourceNotFoundException exc) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Foo Not Found", exc);
//        }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
    }
}

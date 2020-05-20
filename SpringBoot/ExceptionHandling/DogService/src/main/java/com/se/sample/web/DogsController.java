package com.se.sample.web;


import com.se.sample.exception.DogsNotFoundException;
import com.se.sample.exception.DogsServiceException;
import com.se.sample.model.DogDto;
import com.se.sample.repo.Dog;
import com.se.sample.service.DogsService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/dogs")
@RequiredArgsConstructor
@Setter
public class DogsController {
    @Autowired private final DogsService service;

    /**
     * The problem with this approach is Duplication. The catch blocks are generic and will be needed in other
     * endpoints as well (e.g. DELETE, POST etc).
     */
    @GetMapping("/getDogsBase")
    public ResponseEntity<List<Dog>> getDogsBase() {
        int  a= 0;
        List<Dog> dogs;
        try {
            dogs = service.getDogs();
        } catch (DogsServiceException ex) {
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (DogsNotFoundException ex) {
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getDogs() {
        return new ResponseEntity<>(service.getDogs(), HttpStatus.OK);
    }

    @GetMapping("/getDogsException")
    public List<Dog> getDogsException(long id) {
        throw new DogsNotFoundException("No Dog Found Here..");
    }

    @PostMapping
    public void postDogs(@RequestBody DogDto dto) {
        service.add(dto);
    }

    /**
     * к этому методу есть вопросы
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Dog getById(@PathVariable(required = true) long id) {
        Dog dog = service.getDogById(id);
        if(dog == null)
             throw new DogsNotFoundException(id);

        return  dog;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
}

package com.se.sample.repo;

import com.se.sample.model.DogDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockDogProvider {
    private List<Dog> mockDogStore;

    public MockDogProvider() {
        mockDogStore = new ArrayList<>();
        mockDogStore.add(Dog.foo(1, "Benji", 10));
        mockDogStore.add(Dog.foo(2, "Baxter", 9));
        mockDogStore.add(Dog.foo(3, "Brinkley", 8));
        mockDogStore.add(Dog.foo(4, "Daisy", 10));
        mockDogStore.add(Dog.foo(5, "Cujo", 12));
    }

    public List<Dog> getDogs() {
        return mockDogStore;
    }

    public Dog findDogById(long id) {
        for (Dog dog : mockDogStore) {
            if (dog.getId() == id) {
                return dog;
            }
        }
        return null;
    }

    public void add(DogDto dto) {
        mockDogStore.add(Dog.foo(dto.getId(), dto.getName(), dto.getAge()));
    }

    public void delete(long id) {
        int idx = 0;
        for (; idx < mockDogStore.size(); idx++) {
            if (mockDogStore.get(idx).getId() == id) {
                break;
            }
        }
        mockDogStore.remove(idx);
    }
}
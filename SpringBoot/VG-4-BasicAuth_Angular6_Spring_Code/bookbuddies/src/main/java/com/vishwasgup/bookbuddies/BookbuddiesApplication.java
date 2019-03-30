package com.vishwasgup.bookbuddies;

import com.vishwasgup.bookbuddies.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class BookbuddiesApplication {

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/books")
    public Map<String, Book[]> home() {
        Map<String, Book[]> model = new HashMap<String, Book[]>();
        model.put("content", getListOfBooks());
        return model;
    }

    private Book[] getListOfBooks() {
        // Create few books
        Book book1 = new Book("Chinua Achebe", "Nigeria",
                "https://upload.wikimedia.org/wikipedia/en/6/65/ThingsFallApart.jpg", "English",
                "https://en.wikipedia.org/wiki/Things_Fall_Apart", 209, "Things Fall Apart", 1958);

        Book book2 = new Book("Hans Christian Andersen", "Denmark",
                "https://upload.wikimedia.org/wikipedia/commons/5/5b/Hans_Christian_Andersen_%281834_painting%29.jpg", "Danish",
                "https://en.wikipedia.org/wiki/Fairy_Tales_Told_for_Children._First_Collection", 784, "Fairy tales", 1836);

        Book book3 = new Book("Dante Alighieri", "Italy",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Michelino_DanteAndHisPoem.jpg/450px-Michelino_DanteAndHisPoem.jpg",
                "Italian", "https://en.wikipedia.org/wiki/Divine_Comedy", 1928, "The Divine Comedy", 1315);

        return new Book[]{book1, book2, book3};
    }

    public static void main(String[] args) {
		SpringApplication.run(BookbuddiesApplication.class, args);
	}
}

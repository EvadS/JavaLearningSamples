package com.sesample.notes;

import com.sesample.notes.config.PersistenceConfig;
import com.sesample.notes.model.Book;
import com.sesample.notes.service.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@Import(PersistenceConfig.class)
public class SpringbootJavaH2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootJavaH2Application.class, args);
    }

    // Commented cause it not work in tests
//    @Bean
//    public ApplicationRunner booksInitializer(BookService bookService) {
//        return args -> {
//            bookService.create(
//                    new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee"));
//            bookService.create(
//                    new Book("9780451524935", "1984", "George Orwell"));
//            bookService.create(
//                    new Book("9780618260300", "The Hobbit", "J.R.R. Tolkien"));
//        };
//    }
}


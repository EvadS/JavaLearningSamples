package com.se.sample.bookpub;



import com.se.sample.bookpub.entity.Author;
import com.se.sample.bookpub.entity.Book;
import com.se.sample.bookpub.entity.Publisher;
import com.se.sample.bookpub.repository.AuthorRepository;
import com.se.sample.bookpub.repository.BookRepository;
import com.se.sample.bookpub.repository.PublisherRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;

import javax.sql.DataSource;

public class StartupRunner implements CommandLineRunner {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private DataSource ds;

    @Autowired private BookRepository bookRepository;
    @Autowired private AuthorRepository authorRepository;
    @Autowired private PublisherRepository publisherRepository;


    //  @Autowired private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Welcome to the Book Catalog System!");
        logger.info("DataSource: "+ds.toString());

        Author author = new Author("Alex", "Antonov");
        author = authorRepository.save(author);
        Publisher publisher = new Publisher("Packt");
        publisher = publisherRepository.save(publisher);
        Book book = new Book("978-1-78528-415-1",
                "Spring Boot Recipes", author, publisher);
        bookRepository.save(book);
    }

    @Scheduled(initialDelay = 1000, fixedRate = 1000000)
    public void run() {
      //  logger.info("Number of books: " + bookRepository.count());
    }
}
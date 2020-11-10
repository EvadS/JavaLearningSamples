package com.se.sample.bookpub.controller;


import com.se.sample.bookpub.editors.IsbnEditor;
import com.se.sample.bookpub.entity.Book;
import com.se.sample.bookpub.entity.Reviewer;
import com.se.sample.bookpub.model.Isbn;
import com.se.sample.bookpub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    /**
     * configure the IsbnEditor method with the following content:
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Isbn.class, new IsbnEditor());
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //http://localhost:8080/books/978-1-78528-415-1
    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Isbn isbn) {
        return bookRepository.findBookByIsbn(isbn.toString());
    }

    @RequestMapping(value = "/{isbn}/reviewers", method =
            RequestMethod.GET)
    public List<Reviewer> getReviewers(@PathVariable("isbn")
                                               Book book) {
        return book.getReviewers();
    }


//    @RequestMapping(value = "/{isbn}/reviewers", method = RequestMethod.GET)
//    public List<Reviewer> getReviewers(@PathVariable("isbn") Book book) {
//        return book.getReviewers();
//    }


}

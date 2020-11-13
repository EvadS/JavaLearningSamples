package com.sesample.notes.service.impl;


import com.sesample.notes.model.Book;
import com.sesample.notes.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Evgeniy Skiba on 13.11.2020
 * @project base-java-h2
 */
@Service
class InMemoryBookService implements BookService {
    private final Map<String, Book> books = new ConcurrentHashMap<>();

    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

    @Override
    public Book create(Book book) {
        books.put(book.getIsbn(), book);
        return book;
    }

    @Override
    public Optional<Book> find(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }
}
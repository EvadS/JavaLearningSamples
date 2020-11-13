package com.sesample.notes.service;

import com.sesample.notes.model.Book;

import java.util.Optional;

/**
 * @author Evgeniy Skiba on 13.11.2020
 * @project base-java-h2
 */
public interface BookService {
    Iterable<Book> findAll();
    Book create(Book book);
    Optional<Book> find(String isbn);
}

package com.sesample.notes.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeniy Skiba on 13.11.2020
 * @project base-java-h2
 */
public class Book {
    private String isbn;
    private String title;
    private List<String> authors = new ArrayList<>();

    public Book() {
    }

    public Book(String isbn, String title, String ... authors) {
        this.isbn = isbn;
        this.title = title;
        this.authors.addAll(Arrays.asList(authors));
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}

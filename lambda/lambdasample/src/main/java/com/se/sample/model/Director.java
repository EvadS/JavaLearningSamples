package com.se.sample.model;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private int id;
    private String name;
    private String imdb;
    private List<Movie> movies= new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imdb='" + imdb + '\'' +
                ", movies=" + movies +
                '}';
    }

    public Director() {
    }

    public Director(int id, String name, String imdb, List<Movie> movies) {
        this.id = id;
        this.name = name;
        this.imdb = imdb;
        this.movies = movies;
    }
}

package com.se.parser.core.sample.model;

public class Category {
    private int id;
    private String link;
    private String title;

    public Category() {
    }

    public Category(int id, String link, String title) {
        this.id = id;
        this.link = link;

        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
       // return "Category{" + "id=" + id + ", link='" + link + '\'' + ", title='" + title + '\'' + '}';
        return String.format("id:  %5s |link : %45s |,  title : %25s", id, link, title );
    }
}

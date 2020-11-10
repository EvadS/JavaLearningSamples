package com.se.sample.jpa.entities;

import com.sun.xml.internal.ws.developer.Serialization;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class NewsId implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================

    private String title;
    private String language;

    // ======================================
    // =            Constructors            =
    // ======================================

    public NewsId() {
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    // ======================================
    // =         hash, equals, toString     =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsId newsId = (NewsId) o;

        if (!language.equals(newsId.language)) return false;
        if (!title.equals(newsId.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + language.hashCode();
        return result;
    }
}
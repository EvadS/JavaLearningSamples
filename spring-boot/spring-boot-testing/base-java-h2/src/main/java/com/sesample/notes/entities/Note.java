package com.sesample.notes.entities;

/**
 * @author Evgeniy Skiba on 12.11.2020
 * @project base-java-h2
 */

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "notes")
public class Note extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;


    public Note() {
    }

    /**
     * @param title
     * @param content
     */
    public Note(@NotBlank String title, @NotBlank String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
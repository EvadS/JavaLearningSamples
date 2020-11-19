package com.sesample.notes.model;

import javax.validation.constraints.NotBlank;

/**
 * @author Evgeniy Skiba on 12.11.2020
 * @project base-java-h2
 */
public class NoteRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    public NoteRequest() {
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

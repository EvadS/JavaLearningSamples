package com.se.sample.basemvcservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se.sample.basemvcservice.model.audit.DateAudit;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "notes")
@EntityListeners(AuditingEntityListener.class)
public class Note
        extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //not null or empty
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
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
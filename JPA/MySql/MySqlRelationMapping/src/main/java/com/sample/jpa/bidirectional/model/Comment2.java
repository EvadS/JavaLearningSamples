package com.sample.jpa.bidirectional.model;


import com.sample.jpa.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comments2")
public class Comment2 extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Lob
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post2_id", nullable = false)
    private Post2 post2;

    // Getters and Setters (Omitted for brevity)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Comment2(@NotNull String text) {
        this.text = text;
    }

    public Comment2() {
    }

    public void setPost(Post2 post) {
        this.post2 = post;
    }

    public Post2 getPost() {
        return post2;
    }


}
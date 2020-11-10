package com.se.sample.demo.domain;

import javax.persistence.*;

/**
 * Notification representing an event in the ecosystem
 */
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @SequenceGenerator(name = "notification_id_generator", sequenceName = "notification_id_sequence", allocationSize = 1)
    @GeneratedValue(generator = "notification_id_generator")
    private Long id;
    private String message;
    private String source;

    public Notification() {
    }

    public Notification(String message, String source) {
        this.message = message;
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
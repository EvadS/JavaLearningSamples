package com.se.sample.basemvcservice.model.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
public abstract class DateAudit implements Serializable {

    @CreatedDate

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

//    @Column(nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreatedDate
//    private Date createdAt;

    @Column(nullable = false, updatable = false)

    public Instant getCreatedAt() {
        return createdAt;
    }

    @JsonIgnore
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @JsonIgnore
    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
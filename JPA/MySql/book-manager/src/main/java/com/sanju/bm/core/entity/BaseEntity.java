package com.sanju.bm.core.entity;

import com.sanju.bm.core.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass

public abstract class BaseEntity implements Serializable {
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;



    @PrePersist
    protected void onCreate(){
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updated = new Date();
    }

    public BaseEntity() {
    }

    public BaseEntity(String createdBy, String updatedBy, Date created, Date updated, Status status) {
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.created = created;
        this.updated = updated;
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

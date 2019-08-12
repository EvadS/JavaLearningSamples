package com.example.jpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Entity
@Table(name = "node_address")
public class NodeAddress extends AuditModel {
    @Id
    private String id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String title;

    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    @Lob
    private String content;

    @OneToMany(mappedBy = "nodeAddress", cascade = CascadeType.ALL)
    private Set<MinerAddress> nodeAddress;

    public NodeAddress(String id, @NotNull @Size(max = 100) String title,
                       @NotNull @Size(max = 250) String description,
                       @NotNull String content, MinerAddress ... books) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.nodeAddress =  Stream.of(books).collect(Collectors.toSet());
        this.nodeAddress.forEach(x->x.setNodeAddress(this));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

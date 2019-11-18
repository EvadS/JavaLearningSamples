package com.se.example.blogposts.entity;


import io.swagger.annotations.ApiModel;

import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name = "Blog")
//@NamedQueries({
//        @NamedQuery(
//                name = "findAccountById",
//                query = "from Account a where a.id = :id"
//        ),
//})
@ApiModel(description = "All details about the Blog. ")
public class Blog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    private String content;

    @Column(name = "created_on") private Timestamp createdOn;

//    @Column(
//            name="colu(1)mnName";
//            boolean un(2)ique() default false;
//            boolean nu(3)llable() default true;
//            boolean in(4)sertable() default true;
//            boolean up(5)datable() default true;
//            String col(6)umnDefinition() default "";
//            String tab(7)le() default "";
//            int length(8)() default 255;
//    int precis(9)ion() default 0; // decimal precision
//    int scale((10)) default 0; // decimal sca

    public Blog() {
    }

    public Blog(String title, String content) {
        this.setTitle(title);
        this.setContent(content);
    }

    public Blog(int id, String title, String content) {
        this.setId(id);
        this.setTitle(title);
        this.setContent(content);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
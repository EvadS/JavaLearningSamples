package com.se.example.blogposts.models;

import com.se.example.blogposts.entity.Blog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(value = "Blog Model", description = "Blog Model for the documentation", discriminator = "discriminator test")
public class BlogModel {

    private int id;

    @NotNull
    @ApiModelProperty(value = "title", allowableValues = "some text")
    private String title;


    @NotNull
    @ApiModelProperty(value = "content", allowableValues = "some text", required = true, dataType = "java.lang.String")
    private String content;

    public Blog toEntity() {
        return new Blog(this.id, this.title,this.content);

    }

    public BlogModel() {
    }

    public BlogModel(int id, @NotNull String title, @NotNull String content) {
        this.id = id;
        this.title = title;
        this.content = content;
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
}

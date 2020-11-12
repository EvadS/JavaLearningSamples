package com.se.sample.basemvcservice.payload.request;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;

public class BookFullRequestModel {
    @NotBlank
    private String name;

    private  MultipartFile[] files;

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public BookFullRequestModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

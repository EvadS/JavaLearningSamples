package com.hellokoding.uploadingfiles;

import org.springframework.web.multipart.MultipartFile;

public class MyModel {

    private MultipartFile files;
    private String name;

    public MultipartFile getFiles() {
        return files;
    }

    public void setFiles(MultipartFile files) {
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

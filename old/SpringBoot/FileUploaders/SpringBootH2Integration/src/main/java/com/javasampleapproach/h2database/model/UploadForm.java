package com.javasampleapproach.h2database.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {

    MultipartFile file;
    String name;
    int age;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
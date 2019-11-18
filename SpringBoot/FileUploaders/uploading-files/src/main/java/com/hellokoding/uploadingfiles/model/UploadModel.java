package com.hellokoding.uploadingfiles.model;

import com.hellokoding.uploadingfiles.annotation.CertificateConstraint;
import org.springframework.web.multipart.MultipartFile;


@CertificateConstraint
public class UploadModel {
    private String extraField;

    private MultipartFile files;

    //getters and setters


    public UploadModel(String extraField, MultipartFile files) {
        this.extraField = extraField;
        this.files = files;
    }

    public String getExtraField() {
        return extraField;
    }

    public void setExtraField(String extraField) {
        this.extraField = extraField;
    }

    public MultipartFile getFiles() {
        return files;
    }

    public void setFiles(MultipartFile files) {
        this.files = files;
    }
}

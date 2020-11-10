package com.hellokoding.uploadingfiles.model;

import org.springframework.web.multipart.MultipartFile;

public class SignedTransactionDataModel {

    private MultipartFile certificateFile;

    private String signature;

    private String data;

    public MultipartFile getCertificateFile() {
        return certificateFile;
    }

    public void setCertificateFile(MultipartFile certificateFile) {
        this.certificateFile = certificateFile;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

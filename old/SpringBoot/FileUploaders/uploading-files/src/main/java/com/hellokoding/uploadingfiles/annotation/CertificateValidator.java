package com.hellokoding.uploadingfiles.annotation;

import com.hellokoding.uploadingfiles.model.UploadModel;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;


public class CertificateValidator implements ConstraintValidator<CertificateConstraint, UploadModel> {

    @Override
    public void initialize(CertificateConstraint certificateConstraint) {
    }


    @Override
    public boolean isValid(UploadModel multipartFile, ConstraintValidatorContext constraintValidatorContext) {


        try {
            if (multipartFile.getFiles().getBytes().length> 1) {
                int a = 10;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException();
        }

        return false;
    }


}
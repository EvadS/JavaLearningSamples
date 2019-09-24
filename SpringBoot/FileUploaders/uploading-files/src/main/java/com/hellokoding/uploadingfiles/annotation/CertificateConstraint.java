package com.hellokoding.uploadingfiles.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//@Target({ElementType.METHOD, ElementType.FIELD})

@Target({ElementType.METHOD,
        ElementType.FIELD,
        ElementType.PARAMETER,
        ElementType.CONSTRUCTOR,
        ElementType.TYPE
})

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CertificateValidator.class)
public @interface CertificateConstraint {

    String message() default "Invalid mining type code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
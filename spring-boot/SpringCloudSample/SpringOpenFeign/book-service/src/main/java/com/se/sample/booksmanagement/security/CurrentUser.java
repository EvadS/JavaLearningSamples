package com.se.sample.booksmanagement.security;

/**
 * @author Evgeniy Skiba on 11.11.2020
 * @project books-management
 */
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}
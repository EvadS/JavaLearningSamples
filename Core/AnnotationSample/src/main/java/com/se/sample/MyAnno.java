package com.se.sample;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// шилдт java8 полное руководство
//простой тип аннотации
@Retention(RetentionPolicy.RUNTIME )
@interface MyAnno {
    String str();
    int val();
}

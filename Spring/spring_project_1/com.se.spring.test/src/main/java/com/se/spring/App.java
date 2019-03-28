package com.se.spring;

import com.se.spring.config.SpringConfig;
import com.se.spring.service.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestBean bean =  context.getBean(TestBean.class);
        String name = bean.getName();

        System.out.println( "Hello World!" + name );
    }
}

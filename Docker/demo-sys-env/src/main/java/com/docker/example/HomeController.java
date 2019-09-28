package com.docker.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private Environment environment;


    @Value("#{systemEnvironment['My_JAVA_OPTS']}")
    private String host;

    // work
    @Value("${java.home}")
    private String javaHome;


    @Value("#{systemProperties['java.home']}")
    private String javaHome2;


    @Value("#{environment['JAVA_HOME']}")
    private String javaHome3;

    @Value("#{systemEnvironment['JAVA_HOME']}")
    private String javaHome4;

    @Value("#{systemEnvironment['java.home']}")
    private String javaHome5;


    @Value("#{ systemProperties['user.language'] }")
    private String varOne;

    @Value("#{ systemProperties['path'] }")
    private String user;


    @RequestMapping("/")
    public String get() {

        String port = environment.getProperty("local.server.port");

        System.out.println("port  " + port);

        System.out.println("path  " + user);
        System.out.println("javaHome2  " + javaHome2);
        System.out.println("javaHome3  " + javaHome3);
        System.out.println("javaHome4  " + javaHome4);
        return "javaHome2: "+javaHome2+ "; javaHome : " +javaHome+ "; Root WebApplicationContext: initialization completed: " + host ;
    }
}
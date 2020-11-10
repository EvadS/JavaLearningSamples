package com.se.example;

import com.se.example.repository.PostRepository;
import com.se.example.repository.TagRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringJpaWebSampleApplication implements ApplicationRunner {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostRepository postRepository;

    private static final Logger logger = LogManager.getLogger(SpringJpaWebSampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaWebSampleApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.info("logger --- >");

        logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");

        logger.info("logger <--- ");
    }
}


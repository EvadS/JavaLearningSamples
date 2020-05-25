package net.petrikainulainen.gradle.client;

import net.petrikainulainen.gradle.core.MessageService;

import org.apache.log4j.Logger;

//import org.apache.logging.log4j.Logger;

/**
 * @author Evgeniy Skiba on 25.05.2020
 * @project Sceleton
 */
public class HelloWorld {


    private static final Logger logger = Logger.getLogger(HelloWorld.class);


    public static void main(String[] args) {
        MessageService messageService = new MessageService();

        String message = messageService.getMessage();
        logger.info("Received message: " + message);
    }
}

package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Throwable {
      //  SpringApplication.run(Application.class, args);

        SpringApplication app = new SpringApplication(Application.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
    }

}

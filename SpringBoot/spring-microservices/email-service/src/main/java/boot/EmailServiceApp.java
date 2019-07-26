package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "service" })
public class EmailServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApp.class, args);
	}

}

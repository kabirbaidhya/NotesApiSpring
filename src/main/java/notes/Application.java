package notes;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

    	ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        SpringApplication.run(Application.class, args);
    }

}
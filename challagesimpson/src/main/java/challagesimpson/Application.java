package challagesimpson;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class Application {

  public static ApplicationContext context;

public static void main(String[] args) throws IOException {
	context = new AnnotationConfigApplicationContext(AppConfig.class);	
	SpringApplication.run(Application.class, args);
  }

}

package dev.skynet.alpha.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dev.skynet.alpha")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}

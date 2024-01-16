package dev.skynet.alpha.adapters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dev.skynet.alpha")
public class AlphaApplication {

  public static void main(String[] args) {
    SpringApplication.run(AlphaApplication.class, args);
  }

}

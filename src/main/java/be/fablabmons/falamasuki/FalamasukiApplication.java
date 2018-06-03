package be.fablabmons.falamasuki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FalamasukiApplication {

  public static void main(String[] args) {
    SpringApplication.run(FalamasukiApplication.class, args);
  }

  @GetMapping("/")
  public String hello() {
    return "Hello World!";
  }
}

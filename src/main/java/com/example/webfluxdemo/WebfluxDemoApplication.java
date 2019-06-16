package com.example.webfluxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@SpringBootApplication
public class WebfluxDemoApplication implements WebFluxConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(WebfluxDemoApplication.class, args);
  }


}

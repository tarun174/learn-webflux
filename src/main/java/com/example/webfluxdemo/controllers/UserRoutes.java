package com.example.webfluxdemo.controllers;

import com.example.webfluxdemo.handlers.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRoutes {

  @Bean
  public RouterFunction<ServerResponse> route(UserHandler userHandler) {
    return RouterFunctions.route(
        RequestPredicates.POST("/user/add")
            .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
        userHandler::addUser);
  }
}

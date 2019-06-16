package com.example.webfluxdemo.handlers;


import com.example.webfluxdemo.entities.User;
import com.example.webfluxdemo.repositories.ReactiveUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class UserHandler {


    private final ReactiveUserRepository reactiveUserRepository;

    public UserHandler(ReactiveUserRepository reactiveUserRepository) {
        this.reactiveUserRepository = reactiveUserRepository;
    }

    public Mono<ServerResponse> addUser(ServerRequest request) {
        Mono<User> createdUser = request.bodyToMono(User.class).flatMap(reactiveUserRepository::save);
        return ServerResponse.ok().body(createdUser, User.class);
    }
}

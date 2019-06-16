package com.example.webfluxdemo.controllers;

import com.example.webfluxdemo.entities.User;
import com.example.webfluxdemo.repositories.ReactiveUserRepository;
import com.example.webfluxdemo.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class UserController {


    private final UserRepository userRepository;
    private final ReactiveUserRepository reactiveUserRepository;

    public UserController(UserRepository userRepository, ReactiveUserRepository reactiveUserRepository) {
        this.userRepository = userRepository;
        this.reactiveUserRepository = reactiveUserRepository;
    }

    @GetMapping("test")
    public String ping() {
        return "System working!";
    }

    @GetMapping("get")
    public List<User> users() {
        return userRepository.findAll();
    }

    @PostMapping("add")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("addReactive")
    public Mono<User> reactiveAdd(@RequestBody User user) {
        return reactiveUserRepository.save(user);
    }

    @GetMapping("getReactive")
    public Flux<User> reactiveGet() {
        return reactiveUserRepository.findAll();
    }
}

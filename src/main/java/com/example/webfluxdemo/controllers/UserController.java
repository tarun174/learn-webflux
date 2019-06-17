package com.example.webfluxdemo.controllers;

import com.example.webfluxdemo.entities.User;
import com.example.webfluxdemo.repositories.ReactiveCrudRepository;
import com.example.webfluxdemo.repositories.ReactiveUserRepository;
import com.example.webfluxdemo.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class UserController {


    private final UserRepository userRepository;
    private final ReactiveUserRepository reactiveUserRepository;
    private final ReactiveCrudRepository reactiveCrudRepository;


    public UserController(UserRepository userRepository, ReactiveUserRepository reactiveUserRepository, ReactiveCrudRepository reactiveCrudRepository) {
        this.userRepository = userRepository;
        this.reactiveUserRepository = reactiveUserRepository;
        this.reactiveCrudRepository = reactiveCrudRepository;
    }

    @GetMapping("test")
    public String ping() {
        return "System working!";
    }

    @GetMapping("get")
    public List<User> users() {
        return userRepository.findAll();
    }

    @GetMapping("paginatedGet")
    public Page<User> paginatedGet(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return userRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("reactivePaginatedGet")
    public Flux<User> reactivePaginatedGet(@RequestParam int pageSize, @RequestParam int pageNumber, @RequestParam String userName) {
        return reactiveUserRepository.findByUserFName(userName,PageRequest.of(pageNumber, pageSize));
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

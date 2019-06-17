package com.example.webfluxdemo.repositories;

import com.example.webfluxdemo.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ReactiveUserRepository extends ReactiveMongoRepository<User, Integer> {
    Flux<User> findByUserFName(String userName, PageRequest pageRequest);
}

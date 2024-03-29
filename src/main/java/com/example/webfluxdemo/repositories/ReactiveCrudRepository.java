package com.example.webfluxdemo.repositories;

import com.example.webfluxdemo.entities.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReactiveCrudRepository extends ReactiveMongoRepository<User, Integer> {
}

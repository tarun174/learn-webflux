package com.example.webfluxdemo.repositories;

import com.example.webfluxdemo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {}

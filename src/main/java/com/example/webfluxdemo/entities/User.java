package com.example.webfluxdemo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {

    @Id
    private Integer userId;

    private String userFName;
    private String userLName;
}

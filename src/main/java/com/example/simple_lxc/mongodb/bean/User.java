package com.example.simple_lxc.mongodb.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String name;
    private int age ;
}

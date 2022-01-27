package com.example.simple_lxc.mongodb.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Info")
public class Info {

    @Id
    private String id;
}

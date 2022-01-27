package com.example.simple_lxc.mongodb.bean;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ConfigItem")
public class ConfigItem {

    @Id
    private String id;

    private String name;
    private String showName;
    private String type;

}

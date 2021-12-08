package com.example.simple_lxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SimpleLxcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleLxcApplication.class, args);
    }

}

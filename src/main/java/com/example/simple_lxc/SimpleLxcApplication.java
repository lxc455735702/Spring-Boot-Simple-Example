package com.example.simple_lxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableRetry
@SpringBootApplication
public class SimpleLxcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleLxcApplication.class, args);
    }

}

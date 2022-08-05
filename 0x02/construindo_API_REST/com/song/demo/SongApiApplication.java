package com.example.songapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SongApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongApiApplication.class, args);
    }

}

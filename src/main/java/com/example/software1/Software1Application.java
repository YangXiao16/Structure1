package com.example.software1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class Software1Application {

    public static void main(String[] args) {

        SpringApplication.run(Software1Application.class, args);
    }

}

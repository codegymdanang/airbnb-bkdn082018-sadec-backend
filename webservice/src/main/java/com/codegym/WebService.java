package com.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "repository")
@ComponentScan(value = {"service", "Impl", "entity", "com.codegym.test.controller"})
@SpringBootApplication
public class WebService {

    public static void main(String[] args) {
        SpringApplication.run(WebService.class, args);
    }

}

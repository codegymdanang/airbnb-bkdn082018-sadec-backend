package com.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@SpringBootApplication
@EntityScan("entity")
@EnableJpaRepositories(basePackages = "repository")
@ComponentScan(basePackages = {"service", "Impl", "entity", "com.codegym.controller"})
public class WebService {

    public static void main(String[] args) {
        SpringApplication.run(WebService.class, args);
    }

}

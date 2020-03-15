package com.spring.react.springbrreact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan(basePackages = {"com.spring.react.springbrreact"})
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.spring.react.springbrreact.repo"})
public class SpringbrreactApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbrreactApplication.class, args);
    }

}

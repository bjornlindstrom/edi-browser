package com.afconsult.edibrowser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
@EnableAutoConfiguration
@ControllerAdvice
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.afconsult.edibrowser"})
@EntityScan(basePackages = {"com.afconsult.edibrowser.domain"})
public class EdiBrowserApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdiBrowserApplication.class, args);
    }
}

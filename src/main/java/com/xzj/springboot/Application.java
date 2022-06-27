package com.xzj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

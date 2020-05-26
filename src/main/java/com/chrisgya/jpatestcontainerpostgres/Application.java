package com.chrisgya.jpatestcontainerpostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    ApplicationRunner applicationRunner(
//            @Value("${HOME}") String userHome,
//            @Value("${greetings:default hello: ${message-from-application}") String defaultValue) {
//        return args -> log.info()
//
//    }
}

package org.sid.modelsisspringbootfullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ModelsisSpringbootFullstackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelsisSpringbootFullstackApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

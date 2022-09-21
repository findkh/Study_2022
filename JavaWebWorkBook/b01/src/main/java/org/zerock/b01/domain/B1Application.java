package org.zerock.b01.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.zerock.b01.B01Application;

@SpringBootApplication
@EnableJpaAuditing
public class B1Application {
    public static void main(String[] args) {
        SpringApplication.run(B01Application.class, args);
    }
}

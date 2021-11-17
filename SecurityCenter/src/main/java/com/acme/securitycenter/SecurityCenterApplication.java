package com.acme.securitycenter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition
@EnableJpaAuditing
@SpringBootApplication
public class SecurityCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityCenterApplication.class, args);
    }

}

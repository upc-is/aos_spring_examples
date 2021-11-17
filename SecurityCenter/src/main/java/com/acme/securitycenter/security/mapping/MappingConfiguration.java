package com.acme.securitycenter.security.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration("securityMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    public RoleMapper roleMapper() {
        return new RoleMapper();
    }
}

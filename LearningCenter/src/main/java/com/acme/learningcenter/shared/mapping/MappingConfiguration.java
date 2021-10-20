package com.acme.learningcenter.shared.mapping;

import com.acme.learningcenter.learning.mapping.PostMapper;
import com.acme.learningcenter.shared.mapping.EnhancedModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }

}

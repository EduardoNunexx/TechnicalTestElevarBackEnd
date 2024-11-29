package com.elevarvendas.technicalTest.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//swagger configuration
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI configOpenAPI(){
        return new OpenAPI().info(new Info().description("Api documentation").title("Elevar technical test"));
    }
}

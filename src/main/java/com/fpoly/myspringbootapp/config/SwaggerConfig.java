package com.fpoly.myspringbootapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI openApi(){

        return  new OpenAPI().info(new Info().title("Spring Boot Rest API")
                .description("Spring Boot Rest API")
                .contact(new Contact().name("Nguyen Tuan Tai"))
                .version("1.0.0"));


    }
}

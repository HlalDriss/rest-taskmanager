package com.dhlal.resttaskmanager.config;

import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.Value;


@Configuration
public class OpenApiConfig {

    @Value("${openapi.server-url:/}")
    private String serverUrl;

    @Bean
    public OpenAPI taskApiDoc() {
        return new OpenAPI()
                .addServersItem(new io.swagger.v3.oas.models.servers.Server().url(serverUrl))
                .info(new Info()
                        .title("Task Manager API")
                        .description("Spring Boot REST API with JWT Authentication")
                        .version("1.0"))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components().addSecuritySchemes("bearerAuth",
                        new SecurityScheme()
                                .name("Authorization")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("task-api")
                .pathsToMatch("/api/**")
                .build();
    }


}
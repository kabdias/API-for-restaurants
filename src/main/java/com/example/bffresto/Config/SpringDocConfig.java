/*
package com.example.bffresto.Config;

import org.springdoc.core.SpringDocHints;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;

import java.util.Optional;

@Configuration
public class SpringDocConfig {

    @Bean
    public GroupedOpenApi customApi() {
        return GroupedOpenApi.builder()
                .group("custom")
                .pathsToMatch("/api/plats/**")  // Ajoutez le chemin de votre contrôleur
                .build();
    }

    @Bean
    public SwaggerUiConfigParameters swaggerUiConfigParameters(SwaggerUiConfigProperties swaggerUiConfig,
                                                               Optional<SpringDocHints> springDocHintsOptional) {
        SwaggerUiConfigParameters parameters = new SwaggerUiConfigParameters();
        return parameters;
    }
}
*/

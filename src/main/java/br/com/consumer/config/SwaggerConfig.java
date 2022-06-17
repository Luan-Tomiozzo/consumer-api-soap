package br.com.consumer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Luan Pedro Tomiozzo
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi grupo() {
        return GroupedOpenApi.builder()
                .group("webservice-correios")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI documentacao() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("API - Consumo Web-Service SOAP - Correios")
                .version("v1");
    }
}

package br.com.meusindicato.sindicato.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openAPI = new OpenAPI();

        openAPI.setServers(
                List.of(
                        new Server().url("http://localhost:8081"),
                        new Server().url("http://api.meusindicato.com.br")
                )
        );
        openAPI.addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
        openAPI.components(new Components()
                .addSecuritySchemes("bearerAuth",
                        new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
        openAPI.setInfo(new Info()
                .title("Meu Sindicato API")
                .version("v1")
                .description("Documentação da API"));

        return openAPI;
    }

}


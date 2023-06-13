package com.api.ForoChallenge.infra.swanger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo()
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "ForoChallenge",
                "Foro Challenge documentacion",
                "Terminos y servicios",
                contact(),
                "Licencia",
                "url licencia",
                Collections.emptyList().toString()
        );
    }

    private Contact contact(){
        return new Contact("Hhola","www.google.com","contact@gmail.com");
    }

    private ApiKey apiKey(){
        return new ApiKey()
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SACAViX Spring Boot 3 API -------")
                        .version("0.11")
                        .description("Sample app Spring Boot 3 with Swagger")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}

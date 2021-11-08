package com.cius.rest;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.service.contexts.SecurityContext;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDoc(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cius"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .apiInfo(apiInfo())
                ;
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "API TESTER",
                "Untuk tes method",
                "0.0.2-beta",
                "Terms OF Service",
                new Contact("Backend Dev","www.ciuslo.wordpress.com","oookkeee@gmail.com"),
                "License of API","API License URL", Collections.emptyList()
        );
    }
    
   private SecurityContext securityContext(){
       return SecurityContext.builder().securityReferences(defaultSec()).build();
   }
    
   private List<SecurityReference> defaultSec(){
       AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
       AuthorizationScope[] scopes = new AuthorizationScope[1];
       scopes[0] = scope;
       return Arrays.asList(new SecurityReference("OAuth2", scopes));
   }
   private ApiKey apiKey(){
       return new ApiKey("OAuth2","Authorization","header");
   }
}

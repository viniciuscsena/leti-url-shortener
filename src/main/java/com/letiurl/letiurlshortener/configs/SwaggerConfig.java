package com.letiurl.letiurlshortener.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {
    @Value("${app.version}")
    String version;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(metadata())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.letiurl.letiurlshortener.controllers"))
                .paths(PathSelectors.ant("/info/swagger-ui.html"))
                .build();
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("LetiUrl - Shortener URLs")
                .description("API to generate")
                .version(version)
                .build();
    }

}

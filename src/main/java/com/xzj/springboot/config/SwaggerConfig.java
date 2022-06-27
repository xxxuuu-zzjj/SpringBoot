package com.xzj.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.*;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 访问地址
 * http://localhost:8899/swagger-ui/index.html
 */
@Configuration
public class SwaggerConfig {

    @Value("${project.swagger.enabled}")
    private Boolean enableSwagger;

    @Value("${project.swagger.name}")
    private String applicationName;


    @Value("${project.swagger.version}")
    private String applicationVersion;


    @Value("${project.swagger.description}")
    private String applicationDescription;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30).pathMapping("/")
                .enable(enableSwagger)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title(applicationName+" Api 文档")
                .description(applicationDescription)
                .contact(new Contact("Admin", null, ""))
                .version("Application Version: " + applicationVersion + ", Spring Boot Version: " + SpringBootVersion.getVersion())
                .build();
    }

}

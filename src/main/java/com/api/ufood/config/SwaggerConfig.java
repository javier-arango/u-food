package com.api.ufood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * SwaggerUI Configuration
 * To access the api documentation go here:
 * <a href="http://localhost:8080/v2/api-docs"/>
 *
 * To access the api documentation with a UI go here:
 * <a href="http://localhost:8080/swagger-ui/index.html"/>
 */
@Configuration
@EnableWebMvc
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.ufood"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfoBuilder()
                .title("UFood Api Documentation")
                .description("For students at the University of Florida who need to find food services close to them, " +
                        "the UFood is a website that shows students food options in their budget as well as their proximity. " +
                        "Unlike other sites, our product is catered toward UF students and will have a pleasant user experience free for all.")
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }
}
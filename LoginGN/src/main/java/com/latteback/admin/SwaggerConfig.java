package com.latteback.admin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // http://localhost:8080/swagger-ui.html#/
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("REST API") // select a spec
                .apiInfo(info()).select()//
                .apis(RequestHandlerSelectors.basePackage("com.latteback.admin.web")).build();

    }

    private ApiInfo info() {
        return new ApiInfoBuilder().title("LatteBack API").description("<h1>Latte's REST API</h1>")
                .license("Back-End-team").version("3.0").build();
    }
}
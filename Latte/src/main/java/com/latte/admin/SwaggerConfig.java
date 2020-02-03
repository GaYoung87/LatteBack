package com.latte.admin;

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
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) //기본정보
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.latte.admin.web"))  //주소접근 옵션
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST Sample with Swagger")
                .description("스웨거 테스트")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("adamdoha@naver.com")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.github.com/adamdoha")
                .version("2.0")
                .build();
    }
}

//import com.google.common.collect.Lists;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.ResponseEntity;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.
//
//import java.util.Date;
//import java.util.List;
//
//@Configuration
//@EnableSwagger2
//@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
//public class SwaggerConfiguration {
//    @Bean
//public Docket swaggerSpringfoxDocket()
//{ Docket docket = new Docket(DocumentationType.SWAGGER_2)
//        .apiInfo(apiEndPointsInfo())
//        .pathMapping("/")
//        .forCodeGeneration(true)
//        .genericModelSubstitutes(ResponseEntity.class)
//        .ignoredParameterTypes(java.sql.Date.class)
//        .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
//        .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
//        .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
//        .securityContexts(Lists.newArrayList(securityContext()))
//        .securitySchemes(Lists.newArrayList(apiKey()))
//        .useDefaultResponseMessages(false);
//        docket = docket.select()
//                .paths(PathSelectors.any()) .build(); return docket;
//}
//
//private ApiInfo apiEndPointsInfo() {
//    return new ApiInfoBuilder().title("Decide REST API")
//            .description("This documents describes about decide version 7 REST API")
//            .contact(new Contact("Kim Young Hoi", "kimyhcj.tistory.com", "kimyhcj@gmail.com"))
//            .license("Apache 2.0")
//            .version("v1")
//            .build();
//
//}
//
//
//private ApiKey apiKey() {
//    return new ApiKey("JWT","member", "header");
//}
//
//private springfox.documentation.spi.service.contexts.SecurityContext securityContext() {
//    return springfox.documentation.spi.service.contexts.SecurityContext.builder()
//            .securityReferences(defaultAuth())
//            .forPaths(PathSelectors.any())
//            .build();
//
//}
//
//List<SecurityReference> defaultAuth() {
//    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//    authorizationScopes[0] = authorizationScope;
//    return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
//}
//}


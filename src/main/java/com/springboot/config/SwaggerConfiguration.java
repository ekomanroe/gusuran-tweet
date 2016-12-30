package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * Created by eko.j.manurung on 12/9/2016.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Gusuran")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(Arrays.asList(
                        new ParameterBuilder().name("channelId").parameterType("header").modelRef(new ModelRef("string"))
                                .required(true).defaultValue("").description("client's channel id").build(),
                        new ParameterBuilder().name("username").parameterType("header").modelRef(new ModelRef("string"))
                                .required(false).description("client's username").build(),
                        new ParameterBuilder().name("requestId").parameterType("header").modelRef(new ModelRef("string"))
                                .required(true).defaultValue("").description("unique id per request").build()
                ));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST API with Swagger")
                .description("Gusuran tweet api documentation")
                .contact("surung-mengajar")
                .build();
    }
}

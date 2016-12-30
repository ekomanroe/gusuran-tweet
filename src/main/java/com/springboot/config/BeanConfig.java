package com.springboot.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by eko.j.manurung on 12/23/2016.
 */
@Configuration
public class BeanConfig {
    @Bean
    public static DeserializationProblemHandler deserializationProblemHandler() {
        return new DeserializationProblemHandler();
    }

    @Bean
    public static ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        objectMapper.addHandler(BeanConfig.deserializationProblemHandler());

        return objectMapper;
    }
}

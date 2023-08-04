package com.nominori.qrcodeapi.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import java.awt.image.BufferedImage;

@Component
public class ApplicationConfig {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter(){
        return new BufferedImageHttpMessageConverter();
    }

}

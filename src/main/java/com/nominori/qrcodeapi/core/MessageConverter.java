package com.nominori.qrcodeapi.core;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

@Component
public class MessageConverter {

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter(){
        return new BufferedImageHttpMessageConverter();
    }

}

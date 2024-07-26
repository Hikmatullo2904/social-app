package com.socialapp.postservice.config;

import com.socialapp.postservice.utils.CommonUtils;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(HttpHeaders.AUTHORIZATION, CommonUtils.currentRequest().getHeader(HttpHeaders.AUTHORIZATION));
        };
    }

}

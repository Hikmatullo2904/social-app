package com.socialapp.postservice;

import com.socialapp.postservice.aop.Authorize;
import com.socialapp.postservice.aop.OpenAuth;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class PostServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PostServiceApplication.class, args);
        checkAuthAndOpenAuth(context);
    }

    public static void checkAuthAndOpenAuth(ApplicationContext applicationContext) {
        RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
                .getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
        List<RequestMappingInfo> invalidApis = getRequestMappingInfos(requestMappingHandlerMapping);

        if (invalidApis.isEmpty())
            return;

        System.err.println("Authorize yoki OpenAuth annotatsiyasi qo'yilmagan apilar: " + invalidApis.size() + " ta");
        invalidApis.forEach(System.err::println);
        System.exit(0);
    }

    private static @NotNull List<RequestMappingInfo> getRequestMappingInfos(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping
                .getHandlerMethods();

        List<RequestMappingInfo> invalidApis = new ArrayList<>();

        map.forEach((key, val) -> {
            assert key.getPathPatternsCondition() != null;
            if (!key.getPathPatternsCondition().toString().contains("/api/"))
                return;

            if (Objects.isNull(val.getMethodAnnotation(Authorize.class)) && Objects.isNull(val.getMethodAnnotation(OpenAuth.class)))
                invalidApis.add(key);
        });
        return invalidApis;
    }
}

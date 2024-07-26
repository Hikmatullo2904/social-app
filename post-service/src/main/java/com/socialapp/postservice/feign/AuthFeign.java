package com.socialapp.postservice.feign;

import com.socialapp.postservice.config.FeignConfig;
import com.socialapp.postservice.model.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "USER-SERVICE", configuration = FeignConfig.class)
public interface AuthFeign {

    @GetMapping("/auth/v1/user/me")
    UserDTO userMe(@RequestHeader(HttpHeaders.AUTHORIZATION) String token);

}

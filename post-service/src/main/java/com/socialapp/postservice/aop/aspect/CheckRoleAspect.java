package com.socialapp.postservice.aop.aspect;

import com.socialapp.postservice.aop.Authorize;
import com.socialapp.postservice.enums.RoleEnum;
import com.socialapp.postservice.exception.RestException;
import com.socialapp.postservice.model.dto.UserDTO;
import com.socialapp.postservice.service.cacheservice.UserCacheService;
import com.socialapp.postservice.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
@RequiredArgsConstructor
public class CheckRoleAspect {
    private final UserCacheService cacheService;


    @Before(value = "@annotation(authorize)")
    public void checkPermissionExecutor(Authorize authorize) {
        String token = CommonUtils.currentRequest().getHeader(HttpHeaders.AUTHORIZATION);
        UserDTO currentUser = cacheService.get(token);

        RoleEnum[] roles = authorize.roles();
        if (Objects.isNull(roles) || roles.length == 0)
            return;
        boolean match = Arrays.stream(roles).anyMatch(userRoleEnum -> Objects.equals(userRoleEnum, currentUser.getRole()));
        if (match)
            return;

        throw RestException.forbidden();
    }

}
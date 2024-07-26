package com.socialapp.postservice.aop;

import com.socialapp.postservice.enums.RoleEnum;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface Authorize {

    RoleEnum[] roles() default {};

}

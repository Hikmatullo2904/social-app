package com.socialapp.postservice.service.cacheservice;

import com.socialapp.postservice.config.RedisConfig;
import com.socialapp.postservice.feign.AuthFeign;
import com.socialapp.postservice.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCacheService {
    private final AuthFeign authFeign;

    @Cacheable(cacheNames = RedisConfig.USER_CACHE, cacheManager = "userCacheManager", key = "#token")
    public UserDTO get(String token){
        return authFeign.userMe(token);
    }

//    @CachePut(cacheNames = RedisConfig.USER_CACHE, cacheManager = "userCacheManager", key = "#token")
//    public UserDetails update(String token){
//        System.out.println(user.getPhoto());
//        return user;
//    }

//    @CacheEvict(cacheNames = RedisConfig.USER_CACHE, cacheManager = "userCacheManager", key = "#user.id")
//    public void deleteUser(User user){
//    }

}

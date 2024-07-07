package com.socialapp.users.service.interfaces;

import com.socialapp.users.model.dto.UserDto;
import com.socialapp.users.payload.ApiResponse;

import java.util.List;

public interface UserService {

    ApiResponse saveUser(UserDto userDto);
    List<UserDto> getUserFollowers(Long userId);
    List<UserDto> getUserFollowing(Long userId);
    ApiResponse follow(Long userId, Long followingId);
    ApiResponse unfollow(Long userId, Long followingId);
}

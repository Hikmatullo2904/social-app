package com.socialapp.users.service.interfaces;

import com.socialapp.users.model.dto.UserCreateDto;
import com.socialapp.users.model.dto.UserDto;
import com.socialapp.users.payload.ApiResponse;

import java.util.List;

public interface UserService {

    ApiResponse saveUser(UserCreateDto userDto);
    List<UserDto> getUserFollowers(Long userId);
    List<UserDto> getUserFollowing(Long userId);

}

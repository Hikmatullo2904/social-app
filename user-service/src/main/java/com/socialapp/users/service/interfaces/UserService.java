package com.socialapp.users.service.interfaces;

import com.socialapp.users.model.dto.UserCreateDto;
import com.socialapp.users.model.dto.UserDto;
import com.socialapp.users.payload.ApiResponse;

import java.util.List;

public interface UserService {

    ApiResponse<UserDto> saveUser(UserCreateDto userDto);
    ApiResponse<List<UserDto>> getUserFollowers(Long userId);
    ApiResponse<List<UserDto>> getUserFollowing(Long userId);

}

package com.socialapp.users.service.impl;

import com.socialapp.users.mapper.UserMapper;
import com.socialapp.users.model.dto.UserCreateDto;
import com.socialapp.users.model.dto.UserDto;
import com.socialapp.users.model.entity.User;
import com.socialapp.users.payload.ApiResponse;
import com.socialapp.users.repository.UserRepository;
import com.socialapp.users.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public ApiResponse<UserDto> saveUser(UserCreateDto userDto) {
        Optional<User> byEmail = userRepository.findByEmail(userDto.getEmail());
        if(byEmail.isPresent()) {
            throw new RuntimeException("User already exists");
        }
        User user = userRepository.save(userMapper.mapToUser(userDto));
        return new ApiResponse<UserDto>().success(userMapper.mapToUserDto(user));
    }

    @Override
    public ApiResponse<List<UserDto>> getUserFollowers(Long userId) {
        List<UserDto> userDtoList = userMapper.mapToUserDtoList(userRepository.getUserFollowers(userId));
        return new ApiResponse<List<UserDto>>().success(userDtoList);
    }

    @Override
    public ApiResponse<List<UserDto>> getUserFollowing(Long userId) {
        List<UserDto> userDtoList = userMapper.mapToUserDtoList(userRepository.getUserFollowings(userId));
        return new ApiResponse<List<UserDto>>().success(userDtoList);
    }


}

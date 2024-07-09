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
    public ApiResponse saveUser(UserCreateDto userDto) {
        Optional<User> byEmail = userRepository.findByEmail(userDto.getEmail());
        if(byEmail.isPresent()) {
            return new ApiResponse(
                    false,
                    "user with this email already exsists",
                    null
            );
        }
        User user = userRepository.save(userMapper.mapToUser(userDto));
        return new ApiResponse(
                true,
                "saved successfully",
                userMapper.mapToUserDto(user)
        );
    }

    @Override
    public List<UserDto> getUserFollowers(Long userId) {
        return userMapper.mapToUserDtoList(userRepository.getUserFollowers(userId));
    }

    @Override
    public List<UserDto> getUserFollowing(Long userId) {
        return userMapper.mapToUserDtoList(userRepository.getUserFollowings(userId));
    }


}

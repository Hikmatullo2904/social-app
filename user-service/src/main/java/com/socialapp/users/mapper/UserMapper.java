package com.socialapp.users.mapper;

import com.socialapp.users.model.dto.UserCreateDto;
import com.socialapp.users.model.dto.UserDto;
import com.socialapp.users.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public User mapToUser(UserCreateDto userDto) {
        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setImageId(userDto.getImageId());
        return user;
    }

    public UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName(user.getFullName());
        userDto.setEmail(user.getEmail());
        if(user.getImageId() != null)
            userDto.setImage(user.getImageId().toString());
        return userDto;
    }

    public List<UserDto> mapToUserDtoList(List<User> users) {
        if(users.isEmpty()) {
            return new ArrayList<>();
        }

        return users
                .stream()
                .map(this::mapToUserDto)
                .toList();
    }
}

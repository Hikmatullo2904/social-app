package com.socialapp.users.controller;

import com.socialapp.users.model.dto.UserCreateDto;
import com.socialapp.users.model.dto.UserDto;
import com.socialapp.users.payload.ApiResponse;
import com.socialapp.users.service.interfaces.FollowService;
import com.socialapp.users.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final FollowService followService;

    @GetMapping("/followers/{id}")
    public ApiResponse<List<UserDto>> getFollowers(@PathVariable Long id) {
        return userService.getUserFollowers(id);
    }
    @GetMapping("/followings/{id}")
    public ApiResponse<List<UserDto>> getFollowings(@PathVariable Long id) {
        return userService.getUserFollowing(id);
    }

    @PostMapping
    public ApiResponse<UserDto> saveUser(@RequestBody UserCreateDto userDto) {
        return userService.saveUser(userDto);
    }

    @PostMapping("/follow")
    public ApiResponse<Void> follow(@RequestParam Long userId, @RequestParam Long followingId) {
        return followService.follow(userId, followingId);
    }

}

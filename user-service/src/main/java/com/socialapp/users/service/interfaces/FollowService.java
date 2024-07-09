package com.socialapp.users.service.interfaces;

import com.socialapp.users.payload.ApiResponse;

public interface FollowService {
    ApiResponse follow(Long userId, Long followingId);
    ApiResponse unfollow(Long userId, Long followingId);
}

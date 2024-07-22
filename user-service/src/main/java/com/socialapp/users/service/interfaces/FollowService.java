package com.socialapp.users.service.interfaces;

import com.socialapp.users.payload.ApiResponse;

public interface FollowService {
    ApiResponse<Void> follow(Long userId, Long followingId);
    ApiResponse<Void> unfollow(Long userId, Long followingId);
}

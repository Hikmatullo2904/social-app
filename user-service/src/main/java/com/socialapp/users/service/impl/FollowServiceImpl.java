package com.socialapp.users.service.impl;

import com.socialapp.users.model.entity.Follow;
import com.socialapp.users.payload.ApiResponse;
import com.socialapp.users.repository.FollowRepository;
import com.socialapp.users.service.interfaces.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {
    private final FollowRepository followRepository;
    @Override
    public ApiResponse follow(Long userId, Long followingId) {

        boolean alreadyFollowing = followRepository.existsByFollowerIdAndFollowingId(userId, followingId);
        if(alreadyFollowing) {
            return new ApiResponse(
                    false,
                    "you have already followed",
                    null
            );
        }

        Follow follow = new Follow();
        follow.setFollowerId(userId);
        follow.setFollowingId(followingId);
        followRepository.save(follow);
        return new ApiResponse(
                true,
                "success",
                null
        );
    }

    @Override
    public ApiResponse unfollow(Long userId, Long followingId) {
        return null;
    }
}

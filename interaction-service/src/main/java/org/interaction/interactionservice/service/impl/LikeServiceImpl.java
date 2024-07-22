package org.interaction.interactionservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.interaction.interactionservice.model.dto.LikeDto;
import org.interaction.interactionservice.model.entity.Like;
import org.interaction.interactionservice.payload.ApiResponse;
import org.interaction.interactionservice.repository.LikeRepository;
import org.interaction.interactionservice.service.interfaces.LikeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    @Override
    public ApiResponse<Void> like(Long postId, Long userId) {
        if(likeRepository.existsByUserIdAndPostId(userId, postId)) {
            throw new RuntimeException("Already liked");
        }
        Like like = new Like();
        like.setUserId(userId);
        like.setPostId(postId);
        like.setCreatedAt(LocalDateTime.now());
        likeRepository.save(like);
        return new ApiResponse<Void>().success();
    }

    @Override
    public ApiResponse<Void> unlike(Long postId, Long userId) {
        likeRepository.deleteByUserIdAndPostId(userId, postId);
        return new ApiResponse<Void>().success();
    }

    @Override
    public ApiResponse<LikeDto> getLike(Long postId, Long userId) {
        Optional<Like> optionalLike = likeRepository.findByUserIdAndPostId(userId, postId);
        if(optionalLike.isEmpty()) {
            throw new RuntimeException("Like not found");
        }

        Like like = optionalLike.get();
        LikeDto likeDto = new LikeDto();
        likeDto.setId(like.getId());
        return new ApiResponse<LikeDto>().success(likeDto);
    }

    @Override
    public ApiResponse<Integer> getLikeCount(Long postId) {
        Integer countOfLikes = likeRepository.countByPostId(postId);
        return new ApiResponse<Integer>().success(countOfLikes);
    }
}

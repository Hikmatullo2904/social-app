package org.interaction.interactionservice.service.interfaces;


import org.interaction.interactionservice.model.dto.LikeDto;
import org.interaction.interactionservice.payload.ApiResponse;

public interface LikeService {

    ApiResponse<Void> like(Long postId, Long userId);

    ApiResponse<Void> unlike(Long postId, Long userId);

    ApiResponse<LikeDto> getLike(Long postId, Long userId);

    ApiResponse<Integer> getLikeCount(Long postId);
}

package org.interaction.interactionservice.service.interfaces;

import org.interaction.interactionservice.model.dto.CommentCreateDto;
import org.interaction.interactionservice.model.dto.CommentDto;
import org.interaction.interactionservice.payload.ApiResponse;

import java.util.List;

public interface CommentService {

    ApiResponse<CommentDto> addComment(CommentCreateDto dto);
    ApiResponse<CommentDto> getCommentByUserIdAndPostId(Long userId, Long postId);
    ApiResponse<List<CommentDto>> getCommentsByPostId(Long postId);
    ApiResponse<Integer> getCommentCountByPostId(Long postId);

}

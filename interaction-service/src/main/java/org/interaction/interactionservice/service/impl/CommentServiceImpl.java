package org.interaction.interactionservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.interaction.interactionservice.model.dto.CommentCreateDto;
import org.interaction.interactionservice.model.dto.CommentDto;
import org.interaction.interactionservice.model.entity.Comment;
import org.interaction.interactionservice.payload.ApiResponse;
import org.interaction.interactionservice.repository.CommentRepository;
import org.interaction.interactionservice.service.interfaces.CommentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public ApiResponse<CommentDto> addComment(CommentCreateDto dto) {
        Comment comment = new Comment();
        comment.setPostId(dto.getPostId());
        comment.setUserId(dto.getUserId());
        comment.setComment(dto.getComment());
        comment.setCreatedAt(LocalDateTime.now());
        commentRepository.save(comment);

        return new ApiResponse<CommentDto>().success(mapToCommentDto(comment));
    }

    private CommentDto mapToCommentDto(Comment comment) {
        if(comment == null) {
            return null;
        }
        return CommentDto.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .build();
    }

    @Override
    public ApiResponse<CommentDto> getCommentByUserIdAndPostId(Long userId, Long postId) {
        Optional<Comment> commentByUserIdAndPostId = commentRepository.getCommentByUserIdAndPostId(userId, postId);
        return commentByUserIdAndPostId.map(comment -> new ApiResponse<CommentDto>().success(mapToCommentDto(comment))).orElse(null);
    }

    @Override
    public ApiResponse<List<CommentDto>> getCommentsByPostId(Long postId) {
        List<Comment> comments = commentRepository.getCommentsByPostId(postId);
        return new ApiResponse<List<CommentDto>>().success(comments.stream().map(this::mapToCommentDto).toList());
    }

    @Override
    public ApiResponse<Integer> getCommentCountByPostId(Long postId) {
        Integer countOfComments = commentRepository.countByPostId(postId);
        return new ApiResponse<Integer>().success(countOfComments);
    }
}

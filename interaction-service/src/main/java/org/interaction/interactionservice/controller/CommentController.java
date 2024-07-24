package org.interaction.interactionservice.controller;

import lombok.RequiredArgsConstructor;
import org.interaction.interactionservice.model.dto.CommentCreateDto;
import org.interaction.interactionservice.model.dto.CommentDto;
import org.interaction.interactionservice.payload.ApiResponse;
import org.interaction.interactionservice.service.interfaces.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interactions/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ApiResponse<CommentDto> addComment(@RequestBody CommentCreateDto dto){
        return commentService.addComment(dto);
    }

    @GetMapping("/user-comment")
    public ApiResponse<CommentDto> getCommentByUserIdAndPostId(@RequestParam Long userId, @RequestParam Long postId) {
        return commentService.getCommentByUserIdAndPostId(userId, postId);
    }

    @GetMapping("/all/{postId}")
    public ApiResponse<List<CommentDto>> getCommentsByPostId(@PathVariable Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/count/{postId}")
    public ApiResponse<Integer> getCommentCountByPostId(@PathVariable Long postId) {
        return commentService.getCommentCountByPostId(postId);
    }

}

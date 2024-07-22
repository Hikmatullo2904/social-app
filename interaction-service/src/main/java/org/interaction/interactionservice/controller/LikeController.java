package org.interaction.interactionservice.controller;

import lombok.RequiredArgsConstructor;
import org.interaction.interactionservice.model.dto.LikeDto;
import org.interaction.interactionservice.payload.ApiResponse;
import org.interaction.interactionservice.service.interfaces.LikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interaction/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;


    @GetMapping
    public ApiResponse<LikeDto> getLike(@RequestParam Long postId, @RequestParam Long userId) {
        return likeService.getLike(postId, userId);
    }

    @GetMapping("/count/{postId}")
    public ApiResponse<Integer> getLikeCount(@PathVariable Long postId) {
        return likeService.getLikeCount(postId);
    }

    @PostMapping
    public ApiResponse<Void> like(@RequestParam Long postId, @RequestParam Long userId) {
        return likeService.like(postId, userId);
    }

    @DeleteMapping
    public ApiResponse<Void> unlike(@RequestParam Long postId, @RequestParam Long userId) {
        return likeService.unlike(postId, userId);
    }

}

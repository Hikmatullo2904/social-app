package com.socialapp.postservice.controller;

import com.socialapp.postservice.model.dto.PostDto;
import com.socialapp.postservice.payload.ApiResponse;
import com.socialapp.postservice.service.interfaces.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/following")
    public ApiResponse<List<PostDto>> getFollowingPosts(@RequestBody List<Long> userIds) {
        return postService.getFollowingPosts(userIds);
    }

    @GetMapping("/user")
    public ApiResponse<List<PostDto>> getUserPosts(@RequestParam Long userId) {
        return postService.getUserPosts(userId);
    }

    @GetMapping("/{id}")
    public ApiResponse<PostDto> getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PostMapping
    public ApiResponse<PostDto> savePost(@RequestBody PostDto postDto){
        return postService.savePost(postDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

}

package com.socialapp.postservice.service.interfaces;

import com.socialapp.postservice.model.dto.PostDto;
import com.socialapp.postservice.payload.ApiResponse;

import java.util.List;

public interface PostService {
    PostDto savePost(PostDto postDto);

    PostDto getPostById(Long id);

    ApiResponse deletePostById(Long id);
    List<PostDto> getFollowingPosts(Long userId);
}

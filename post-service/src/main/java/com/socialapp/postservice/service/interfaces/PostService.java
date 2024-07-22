package com.socialapp.postservice.service.interfaces;

import com.socialapp.postservice.model.dto.PostDto;
import com.socialapp.postservice.payload.ApiResponse;

import java.util.List;

public interface PostService {
    ApiResponse<PostDto> savePost(PostDto postDto);

    ApiResponse<PostDto> getPost(Long id);

    ApiResponse<Void> deletePost(Long id);
    ApiResponse<List<PostDto>> getFollowingPosts(List<Long> userIds);

    ApiResponse<List<PostDto>> getUserPosts(Long id);
}

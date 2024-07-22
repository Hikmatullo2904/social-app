package com.socialapp.postservice.service.impl;

import com.socialapp.postservice.mapper.PostMapper;
import com.socialapp.postservice.model.dto.PostDto;
import com.socialapp.postservice.model.entity.Post;
import com.socialapp.postservice.payload.ApiResponse;
import com.socialapp.postservice.repository.PostRepository;
import com.socialapp.postservice.service.interfaces.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public ApiResponse<PostDto> savePost(PostDto postDto) {
        Post post = postMapper.toEntity(postDto);
        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);
        PostDto dto = postMapper.toDto(post);
        return new ApiResponse<PostDto>().success(dto);
    }

    @Override
    public ApiResponse<PostDto> getPost(Long id) {
        Optional<Post> byId = postRepository.findById(id);
        PostDto postDto = byId.map(postMapper::toDto).orElse(null);
        return new ApiResponse<PostDto>().success(postDto);
    }

    @Override
    public ApiResponse<Void> deletePost(Long id) {
        postRepository.deleteById(id);
        return new ApiResponse<Void>().success();
    }

    @Override
    public ApiResponse<List<PostDto>> getFollowingPosts(List<Long> userIds) {
        List<PostDto> dtoList = postMapper.toDtoList(postRepository.getFollowingPosts(userIds));
        return new ApiResponse<List<PostDto>>().success(dtoList);
    }

    @Override
    public ApiResponse<List<PostDto>> getUserPosts(Long id) {
        List<PostDto> dtoList = postMapper.toDtoList(postRepository.getUserPosts(id));
        return new ApiResponse<List<PostDto>>().success(dtoList);
    }
}

package com.socialapp.postservice.mapper;

import com.socialapp.postservice.model.dto.PostDto;
import com.socialapp.postservice.model.entity.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostMapper {

    public List<PostDto> toDtoList(List<Post> posts) {

        if(posts == null || posts.isEmpty()) {
            return new ArrayList<>();
        }

        return posts
                .stream()
                .map(this::toDto)
                .toList();
    }

    public PostDto toDto(Post post) {

        if(post == null) {
            return null;
        }

        return PostDto
                .builder()
                .id(post.getId())
                .description(post.getDescription())
                .imageId(post.getImageId())
                .userId(post.getUserId())
                .build();
    }

    public Post toEntity(PostDto postDto) {

        if(postDto == null) {
            return null;
        }
        return Post
                .builder()
                .id(postDto.getId())
                .description(postDto.getDescription())
                .imageId(postDto.getImageId())
                .userId(postDto.getUserId())
                .build();
    }
}

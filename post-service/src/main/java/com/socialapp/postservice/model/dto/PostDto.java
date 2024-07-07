package com.socialapp.postservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private Long id;
    private String text;
    private String image;
    private Long userId;
}

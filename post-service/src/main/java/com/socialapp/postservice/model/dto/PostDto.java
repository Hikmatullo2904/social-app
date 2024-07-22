package com.socialapp.postservice.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostDto {
    private Long id;
    private String description;
    private Long imageId;
    private Long userId;
}

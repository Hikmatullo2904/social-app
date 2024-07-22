package org.interaction.interactionservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentCreateDto {
    private Long userId;
    private Long postId;
    private String comment;
}

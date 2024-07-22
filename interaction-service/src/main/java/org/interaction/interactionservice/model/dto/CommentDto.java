package org.interaction.interactionservice.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommentDto {
    private Long id;
    private String comment;
}

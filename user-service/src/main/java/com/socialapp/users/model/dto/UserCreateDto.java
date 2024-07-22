package com.socialapp.users.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    private Long id;
    private String fullName;
    private String email;
    private Long imageId;
    private String password;
}

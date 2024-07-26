package com.socialapp.postservice.model.dto;

import com.socialapp.postservice.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private Long id;
    private String email;
    private String fullName;
    private RoleEnum role;

}

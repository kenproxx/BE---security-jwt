package com.example.airbnb.dto;

import com.example.airbnb.model.RoleExtend;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    private Long id;

    private String name;

    private String username;

    private String status;

    private String roleId;

    private RoleExtend role;

    private String token;
}

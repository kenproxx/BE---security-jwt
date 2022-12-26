package com.example.airbnb.dto;

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


    private String token;
}

package com.example.airbnb.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class RoleExtend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;

    @NotNull
    @NotBlank
    private String id;

    private String name;

    private String status;

    @OneToMany
    private List<Permission> permissions;
}

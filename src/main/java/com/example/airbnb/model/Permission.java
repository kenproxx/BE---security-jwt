package com.example.airbnb.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String roleId;

    @NotNull
    @NotBlank
    private String permissionId;

    @NotNull
    @NotBlank
    private String permissionName;

    @NotNull
    @NotBlank
    private String actions;

    @OneToMany
    private List<ActionEntitySet> actionEntitySet;



}

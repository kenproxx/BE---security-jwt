package com.example.airbnb.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class SearchUserDetail {
    @Nullable
    private String username;
    @Nullable
    private String tenGoi;
    @Nullable
    private Long lopId;
    @Nullable
    private String nganh;

    @Nullable
    private int page;
    @Nullable
    private int size;
}

package com.example.airbnb.dto;

import com.example.airbnb.model.ThongSo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TongSoNganh {
    @Nullable
    private Long id;

    @Nullable
    private String dienGiai;

    @Nullable
    private int giaTri;

    @Nullable
    private int soLuong;

    @Nullable
    private String loai;


}

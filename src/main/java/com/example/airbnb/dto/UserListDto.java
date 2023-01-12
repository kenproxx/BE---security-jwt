package com.example.airbnb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserListDto {
    private Long id;

    private String username;
    private String tenDayDu;
    private String avatar;
    private String soDienThoaiCaNhan;
    private String nganh;
    private Long lopId;
    private String trangThaiHocTap;

}

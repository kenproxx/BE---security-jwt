package com.example.airbnb.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserInfoDto {

    private Long udid;

    private String username;

    private String tenThanh;

    private String tenGoi;

    private Date ngayThangNamSinh;

    private Integer soDienThoaiCaNhan;

    private String email;

    private String anhDaiDien;

    private String diaChi;

    private Integer giaoXuId;

    private Integer lopId;

    private Character nganh;

    private String roleId;
}

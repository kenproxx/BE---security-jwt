package com.example.airbnb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserListDto {
    private Long id;
    private String tenDayDu;
    private String avatar;
    private Integer sdt;
    private String nganh;
    private Long lopId;
    private String capBacHuynhTruong;
    private String status;

    public UserListDto(Long id,String tenDayDu, String avatar, Integer sdt, String nganh,
                       Long lopId, String capBacHuynhTruong, String status) {
        this.id = id;
        this.tenDayDu = tenDayDu;
        this.avatar = avatar;
        this.sdt = sdt;
        this.nganh = nganh;
        this.lopId = lopId;
        this.capBacHuynhTruong = capBacHuynhTruong;
        this.status = status;
    }
}

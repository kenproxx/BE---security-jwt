package com.example.airbnb.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long udid;

    @Column(unique = true)
    private String username;

    private String tenThanh;

    private String tenGoi;

    private Date ngayThangNamSinh;

    private Integer soDienThoaiCaNhan;

    private String email;

    private Date ngayRuaToi;

    private String nguoiRuaToi;

    private String nguoiDoDauRuaToi;

    private Date ngayThemSuc;

    private String nguoiThemSuc;

    private String nguoiDoDauThemSuc;

    private Date ngayBonMang;

    private String anhDaiDien;

    private String tenBo;

    private Integer sdtBo;

    private String tenMe;

    private Integer sdtMe;

    private String diaChi;

    private Integer giaoXuId;

    private Integer lopId;

    private Character nganh;

    private Integer parentCode;

    private Character capBacHuynhTruong;

    private String roleId;

}

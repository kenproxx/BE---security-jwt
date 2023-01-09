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

    private String tenDayDu;

    private String gioiTinh;

    private Date ngayThangNamSinh;

    private String soDienThoaiCaNhan;

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

    private String sdtBo;

    private String tenMe;

    private String sdtMe;

    private String diaChi;

    private Integer giaoXuId;

    private Long lopId;

    private String nganh;

    private Integer parentCode;

    private String capBacHuynhTruong;

    private String roleId;

    private String trangThaiHocTap;

}

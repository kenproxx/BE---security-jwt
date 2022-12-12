package com.example.airbnb.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.util.Date;

@Entity
@Table(name = "UserDetail")
@Data
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long udid;

    @Column(unique = true, nullable = false)
    private String username;

    @Length(max = 30)
    private String tenThanh;

    @Length(max = 50)
    private String tenGoi;

    private Date ngayThangNamSinh;

    @Max(13)
    private Integer soDienThoaiCaNhan;

    @Email
    private String email;

    private Date ngayRuaToi;

    @Length(max = 70)
    private String nguoiRuaToi;

    @Length(max = 70)
    private String nguoiDoDauRuaToi;

    private Date ngayThemSuc;

    @Length(max = 70)
    private String nguoiThemSuc;

    @Length(max = 70)
    private String nguoiDoDauThemSuc;

    private Date ngayBonMang;

    @Length(max = 254)
    private String anhDaiDien;

    @Length(max = 70)
    private String tenBo;

    @Max(13)
    private Integer sdtBo;

    @Length(max = 70)
    private String tenMe;

    @Max(13)
    private Integer sdtMe;

    @Length(max = 254)
    private String diaChi;

    @Max(10)
    private Integer giaoXuId;

    @Max(10)
    private Integer lopId;

    private Character nganh;

    @Max(10)
    private Integer parentCode;

    private Character capBacHuynhTruong;

}

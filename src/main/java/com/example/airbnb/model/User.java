package com.example.airbnb.model;

import lombok.Data;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "userTable")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String confirmPassword;
    private boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    @Length(max = 20)
    private String tenThanh;

    @Length(max = 40)
    private String tenGoi;

    private Date ngayThangNamSinh;

    @Max(13)
    private Integer soDienThoaiCaNhan;

    @Email
    @Length(max = 50)
    private String email;

    private Date ngayRuaToi;

    @Length(max = 50)
    private String nguoiRuaToi;

    @Length(max = 50)
    private String nguoiDoDauRuaToi;

    private Date ngayThemSuc;

    @Length(max = 50)
    private String nguoiThemSuc;

    @Length(max = 50)
    private String nguoiDoDauThemSuc;

    private Date ngayCuHanhHonPhoi;

    @Length(max = 50)
    private String nguoiCuHanhHonPhoi;

    @Max(10)
    private Integer phoiNgauId;

    @Max(10)
    private Integer nguoiLamChung1Id;

    @Max(10)
    private Integer nguoiLamChung2Id;

    private Date ngayBonMang;

    @Length(max = 254)
    private String anhDaiDien;

    @Length(max = 50)
    private String tenBo;

    @Max(13)
    private Integer sdtBo;

    @Length(max = 50)
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

    private boolean trangThai;

}

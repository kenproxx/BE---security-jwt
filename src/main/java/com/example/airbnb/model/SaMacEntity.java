package com.example.airbnb.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Date;

@Entity
@Data
@Table(name = "sa_mac_entity")
public class SaMacEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maSaMac;

    @Length(max = 30)
    private String tenSaMac;

    private Date ngayBatDau;

    @Max(10)
    private Integer noiToChucId;

    @Length(max = 50)
    private String tuyenUySaMac;

    @Length(max = 50)
    private String saMacTruong;

    @Length(max = 50)
    private String saMacPho;

    @Max(10)
    private Integer parentCode;
}

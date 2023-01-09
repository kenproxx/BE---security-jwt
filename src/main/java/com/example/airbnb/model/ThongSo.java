package com.example.airbnb.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(indexes =
    @Index(name = "fn_index", columnList = "ten")
        )
public class ThongSo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ten;

    private int giaTri;

    private String loai;


}

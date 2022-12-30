package com.example.airbnb.controller;

import com.example.airbnb.model.ThongSo;
import com.example.airbnb.service.impl.ThongSoService;
import com.example.airbnb.service.impl.UserDetailService;
import com.example.airbnb.utils.ApiConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
@RequestMapping(ApiConstant.THONG_SO)
public class ThongSoController {
    @Autowired
    private ThongSoService thongSoService;

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping
    public List<ThongSo> getThongSo(@RequestParam String loai) {
        return thongSoService.findAllByLoai(loai);
    }


}

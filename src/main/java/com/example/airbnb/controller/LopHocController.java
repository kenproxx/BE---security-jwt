package com.example.airbnb.controller;

import com.example.airbnb.model.LopHoc;
import com.example.airbnb.service.impl.LopHocServiceImpl;
import com.example.airbnb.utils.ApiConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
@RequestMapping(ApiConstant.LOP_HOC)
public class LopHocController {
    @Autowired
    private LopHocServiceImpl lopHocService;

    @PostMapping(ApiConstant.ADD)
    public ResponseEntity<LopHoc> createLopHoc(@RequestBody LopHoc lopHoc) {
        return lopHocService.createLopHoc(lopHoc);
    }

    @GetMapping(ApiConstant.GET_ALL)
    public ResponseEntity<Iterable<LopHoc>> showAllLopHoc() {
        return ResponseEntity.ok(lopHocService.findAll());
    }
}

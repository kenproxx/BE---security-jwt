package com.example.airbnb.controller;

import com.example.airbnb.model.LopHoc;
import com.example.airbnb.model.UserDetail;
import com.example.airbnb.service.impl.LopHocServiceImpl;
import com.example.airbnb.service.impl.UserDetailService;
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

    @Autowired
    private UserDetailService userDetailService;

    @PostMapping(ApiConstant.ADD)
    public ResponseEntity<LopHoc> createLopHoc(@RequestBody LopHoc lopHoc) {
        return lopHocService.createLopHoc(lopHoc);
    }

    @GetMapping(ApiConstant.GET_ALL)
    public ResponseEntity<?> showAllLopHoc(@RequestParam String role
            , @RequestParam(required = false) String username) {
        if(role.equals("admin")) {
            return ResponseEntity.ok(lopHocService.findAll());
        } else {
            UserDetail userDetail = userDetailService.findByUsername(username);
            return ResponseEntity.ok(lopHocService.findById(userDetail.getLopId()));
        }
    }

    @PutMapping(ApiConstant.UPDATE)
    public ResponseEntity<LopHoc> updateLopHoc(@RequestBody LopHoc lopHoc) {
        return lopHocService.updateLopHoc(lopHoc);
    }

    @DeleteMapping(ApiConstant.DELETE)
    public ResponseEntity<?> deleteLopHoc(@RequestParam Long id) {
        return lopHocService.deleteLopHoc(id);
    }


}

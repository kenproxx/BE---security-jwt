package com.example.airbnb.controller;

import com.example.airbnb.model.RoleExtend;
import com.example.airbnb.service.impl.RoleExtendService;
import com.example.airbnb.utils.ApiConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
@RequestMapping(ApiConstant.ROLE_EXTEND)
public class RoleExtendController {
    @Autowired
    private RoleExtendService roleExtendService;

    @GetMapping
    public RoleExtend getAllRoleExtend(@RequestParam String id) {
        return roleExtendService.getById(id);
    }
}

package com.example.airbnb.controller;

import com.example.airbnb.model.User;
import com.example.airbnb.model.UserDetail;
import com.example.airbnb.service.UserService;
import com.example.airbnb.service.impl.UserDetailService;
import com.example.airbnb.service.impl.UserServiceImpl;
import com.example.airbnb.utils.ApiConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
@RequestMapping(ApiConstant.USER)
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<Iterable<User>> showAllUser() {
        Iterable<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/detail")
    public ResponseEntity<UserDetail> showUserDetail(@RequestParam String username) {
        return ResponseEntity.ok(userDetailService.findByUsername(username));
    }

}

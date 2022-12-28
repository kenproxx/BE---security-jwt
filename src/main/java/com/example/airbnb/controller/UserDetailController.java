package com.example.airbnb.controller;

import com.example.airbnb.dto.SearchUserDetail;
import com.example.airbnb.model.User;
import com.example.airbnb.model.UserDetail;
import com.example.airbnb.service.impl.UserDetailService;
import com.example.airbnb.service.impl.UserServiceImpl;
import com.example.airbnb.utils.ApiConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
@RequestMapping(ApiConstant.USER)
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(ApiConstant.GET_ALL)
    public ResponseEntity<Iterable<User>> showAllUser() {
        Iterable<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(ApiConstant.SEARCH)
    public ResponseEntity<List<UserDetail>> searchUserDetail(@RequestBody SearchUserDetail searchUserDetail) {
        List<UserDetail> users = userDetailService.searchUserDetail(searchUserDetail);
        return ResponseEntity.ok(users);
    }

    @GetMapping(ApiConstant.DETAIL)
    public ResponseEntity<UserDetail> showUserDetail(@RequestParam String username) {
        return ResponseEntity.ok(userDetailService.findByUsername(username));
    }

    @PutMapping(ApiConstant.UPDATE)
    public ResponseEntity<UserDetail> updateUserDetail(@RequestBody UserDetail userDetail) {
        return userDetailService.updateDetail(userDetail);
    }

    @PutMapping("/change-password")
    public ResponseEntity<User> changePasswordUser(@RequestBody User user) {
        return userService.changePassword(user);
    }

    @PutMapping("/add-to-class")
    public ResponseEntity<UserDetail> addToClass(@RequestParam String username, @RequestParam Long classId) {
        return userDetailService.addToClass(username, classId);
    }
}

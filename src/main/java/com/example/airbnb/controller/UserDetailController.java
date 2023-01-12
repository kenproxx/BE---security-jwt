package com.example.airbnb.controller;

import com.example.airbnb.dto.SearchUserDetail;
import com.example.airbnb.dto.TongSoNganh;
import com.example.airbnb.dto.UserListDto;
import com.example.airbnb.model.User;
import com.example.airbnb.model.UserDetail;
import com.example.airbnb.service.impl.UserDetailService;
import com.example.airbnb.service.impl.UserServiceImpl;
import com.example.airbnb.utils.ApiConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
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
    public ResponseEntity<Iterable<UserDetail>> showAllUser(@RequestParam @Nullable int page, @RequestParam @Nullable int size) {
        Iterable<UserDetail> users = userDetailService.findAll( page, size);
        return ResponseEntity.ok(users);
    }


//    @GetMapping(ApiConstant.SEARCH)
//    public ResponseEntity<Iterable<UserDetail>> search( @RequestParam @Nullable String username,
//                                                        @RequestParam @Nullable String tenGoi,
//                                                        @RequestParam @Nullable Long lopId,
//                                                        @RequestParam @Nullable String nganh,
//                                                        @RequestParam @Nullable int page,
//                                                        @RequestParam @Nullable int size) {
//        Iterable<UserDetail> users = userDetailService.search( username, tenGoi, lopId, nganh, page, size);
//        return ResponseEntity.ok(users);
//    }

//    public ResponseEntity<List<UserDetail>> searchUserDetail(@RequestBody SearchUserDetail searchUserDetail) {
//        List<UserDetail> users = userDetailService.searchUserDetail(searchUserDetail);
//        return ResponseEntity.ok(users);
//    }

    @GetMapping(ApiConstant.DETAIL)
    public ResponseEntity<UserDetail> showUserDetail(@RequestParam String username) {
        return ResponseEntity.ok(userDetailService.findByUsername(username));
    }

    @PutMapping(ApiConstant.UPDATE)
    public ResponseEntity<UserDetail> updateUserDetail(@RequestBody UserDetail userDetail) {
        return userDetailService.updateDetail(userDetail);
    }

    @PutMapping(ApiConstant.CHANGE_PASSWORD)
    public ResponseEntity<User> changePasswordUser(@RequestBody User user) {
        return userService.changePassword(user);
    }

    @PutMapping("/add-to-class")
    public ResponseEntity<UserDetail> addToClass(@RequestParam String username, @RequestParam Long classId) {
        return userDetailService.addToClass(username, classId);
    }


    @PutMapping("/add-list-to-class")
    public ResponseEntity<UserDetail> addStudentToClass(@RequestBody List<UserDetail> userDetails, @RequestParam Long classId) {
        return userDetailService.addToClass(userDetails, classId);
    }


    @GetMapping(ApiConstant.GET_ALL_THONG_SO)
    public ResponseEntity<List<TongSoNganh>> getAllThongSo() {
        return ResponseEntity.ok(userDetailService.getAllThongSo());
    }
}

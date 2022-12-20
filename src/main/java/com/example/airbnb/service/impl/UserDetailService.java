package com.example.airbnb.service.impl;

import com.example.airbnb.model.User;
import com.example.airbnb.model.UserDetail;
import com.example.airbnb.repository.LopHocRepository;
import com.example.airbnb.repository.UserDetailRepository;
import com.example.airbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {
    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LopHocRepository lopHocRepository;

    public void save(UserDetail userDetail) {
        userDetailRepository.save(userDetail);
    }

    public Iterable<UserDetail> findAll() {
        return userDetailRepository.findAll();
    }

    public UserDetail findByUsername(String username) {
        return userDetailRepository.findByUsername(username);
    }

    public ResponseEntity<UserDetail> updateDetail(UserDetail userDetail) {
        if(userRepository.existsByUsername(userDetail.getUsername())) {
            if(userDetailRepository.existsByUsername(userDetail.getUsername())) {
                UserDetail currentUser = userDetailRepository.findByUsername(userDetail.getUsername());
                userDetail.setUdid(currentUser.getUdid());
            }
            save(userDetail);
            return ResponseEntity.ok(userDetail);
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<UserDetail> addToClass(String username, int classId) {
        if(lopHocRepository.existsById((long) classId)) {
            if(userRepository.existsByUsername(username)) {
                UserDetail userDetail = findByUsername(username);
                userDetail.setLopId(classId);
                save(userDetail);
                return ResponseEntity.ok(userDetail);
            }
        }
        return ResponseEntity.badRequest().build();
    }
}

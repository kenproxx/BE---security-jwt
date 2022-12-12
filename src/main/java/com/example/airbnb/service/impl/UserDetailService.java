package com.example.airbnb.service.impl;

import com.example.airbnb.model.UserDetail;
import com.example.airbnb.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {
    @Autowired
    private UserDetailRepository userDetailRepository;

public void save(UserDetail userDetail) {
        userDetailRepository.save(userDetail);
    }

    public Iterable<UserDetail> findAll() {
        return userDetailRepository.findAll();
    }

    public UserDetail findByUsername(String username) {
        return userDetailRepository.findByUsername(username);
    }
}

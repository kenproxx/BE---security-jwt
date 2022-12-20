package com.example.airbnb.service.impl;

import com.example.airbnb.model.RoleExtend;
import com.example.airbnb.repository.RoleExtendRepository;
import com.example.airbnb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleExtendService {
    @Autowired
    private RoleExtendRepository roleRepository;

    public RoleExtend getById(String id) {
        return roleRepository.getById(id);
    }
}

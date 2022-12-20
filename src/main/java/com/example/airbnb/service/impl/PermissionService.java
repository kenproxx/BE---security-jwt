package com.example.airbnb.service.impl;

import com.example.airbnb.model.Permission;
import com.example.airbnb.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> getAllPermission() {
        return permissionRepository.findAll();
    }
}

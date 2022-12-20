package com.example.airbnb.repository;

import com.example.airbnb.model.RoleExtend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleExtendRepository extends JpaRepository<RoleExtend, Long> {
    RoleExtend getById(String id);
}

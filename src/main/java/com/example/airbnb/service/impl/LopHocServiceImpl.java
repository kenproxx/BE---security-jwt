package com.example.airbnb.service.impl;

import com.example.airbnb.model.LopHoc;
import com.example.airbnb.repository.LopHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LopHocServiceImpl {
    @Autowired
    private LopHocRepository lopHocRepository;

    public void save(LopHoc lopHoc) {
        lopHocRepository.save(lopHoc);
    }

    public Iterable<LopHoc> findAll() {
        return lopHocRepository.findAll();
    }

    public LopHoc findById(Long id) {
        return lopHocRepository.findById(id).get();
    }

    public Iterable<LopHoc> findByUsername(String tenLop) {
        return lopHocRepository.findAllByTenLopContaining(tenLop);
    }

    public boolean isExist(String tenLop) {
        return lopHocRepository.existsByTenLop(tenLop);
    }

    public ResponseEntity<LopHoc> createLopHoc(LopHoc lopHoc) {
        if (!isExist(lopHoc.getTenLop())) {
            save(lopHoc);
            return ResponseEntity.ok(lopHoc);
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<LopHoc> updateLopHoc(LopHoc lopHoc) {
        if (lopHocRepository.existsById(lopHoc.getId())) {
            save(lopHoc);
            return ResponseEntity.ok(lopHoc);
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<LopHoc> deleteLopHoc(Long id) {
        if (lopHocRepository.existsById(id)) {
            lopHocRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }



}

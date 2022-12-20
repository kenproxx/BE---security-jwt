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

    public Iterable<LopHoc> findByUsername(String tenLop) {
        return lopHocRepository.findAllByTenLopContaining(tenLop);
    }

    public boolean isExist(LopHoc lopHoc) {
        return lopHocRepository.existsByTenLop(lopHoc.getTenLop());
    }

    public ResponseEntity<LopHoc> createLopHoc(LopHoc lopHoc) {
        if (!isExist(lopHoc)) {
            save(lopHoc);
            return ResponseEntity.ok(lopHoc);
        }
        return ResponseEntity.badRequest().build();
    }

}

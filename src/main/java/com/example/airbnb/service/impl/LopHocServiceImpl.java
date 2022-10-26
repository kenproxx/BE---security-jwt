package com.example.airbnb.service.impl;

import com.example.airbnb.model.LopHoc;
import com.example.airbnb.repository.LopHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LopHocServiceImpl  {
    @Autowired
    private LopHocRepository lopHocRepository;

    public boolean insertItem(LopHoc lopHoc) {
        if (lopHoc.getTenLop() != null && lopHoc.getTenLop() != "") {
            lopHocRepository.save(lopHoc);
            return true;
        }
        return false;
    }

    public Iterable<LopHoc> findAll() {
        return lopHocRepository.findAll();
    }

    public boolean editItem(LopHoc lopHoc) {
        if (lopHoc.getTenLop() != null && lopHoc.getTenLop() != "") {
            lopHocRepository.save(lopHoc);
            return true;
        }
        return false;
    }

    public boolean deleteItem(LopHoc lopHoc) {
        LopHoc item = lopHocRepository.findById(lopHoc.getId()).get();
        if (item != null) {
            lopHocRepository.delete(lopHoc);
        }
        return false;
    }
}

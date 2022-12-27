package com.example.airbnb.service.impl;

import com.example.airbnb.model.ThongSo;
import com.example.airbnb.repository.ThongSoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThongSoService {
    @Autowired
    private ThongSoRepository thongSoRepository;

    public List<ThongSo> findAllByLoai(String loai) {
        return thongSoRepository.findAllByLoai(loai);
    }
}

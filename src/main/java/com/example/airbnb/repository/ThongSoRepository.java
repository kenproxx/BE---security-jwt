package com.example.airbnb.repository;

import com.example.airbnb.model.ThongSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThongSoRepository extends JpaRepository<ThongSo, Long> {
    List<ThongSo> findAllByLoai(String loai);
}

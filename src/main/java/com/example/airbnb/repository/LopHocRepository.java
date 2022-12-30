package com.example.airbnb.repository;

import com.example.airbnb.model.LopHoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LopHocRepository extends JpaRepository<LopHoc, Long> {
    Iterable<LopHoc> findAllByTenLopContaining(String tenLop);

    boolean existsByTenLop(String tenLop);

    boolean existsById(Long id);

}

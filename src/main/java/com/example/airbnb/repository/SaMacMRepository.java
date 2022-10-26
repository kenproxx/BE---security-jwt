package com.example.airbnb.repository;

import com.example.airbnb.model.SaMacManage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaMacMRepository extends JpaRepository<SaMacManage, Long> {
}

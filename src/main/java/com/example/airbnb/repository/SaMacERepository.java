package com.example.airbnb.repository;

import com.example.airbnb.model.SaMacEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaMacERepository extends JpaRepository<SaMacEntity, Long> {
}

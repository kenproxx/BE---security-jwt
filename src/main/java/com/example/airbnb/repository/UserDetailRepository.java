package com.example.airbnb.repository;


import com.example.airbnb.model.User;
import com.example.airbnb.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    UserDetail findByUsername(String username);
}

package com.springboot.app.auth.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.app.auth.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long> {

    @Query("""
            SELECT u
            FROM UserEntity u
            JOIN FETCH u.rol
            WHERE u.email = ?1
            """)
    Optional<UserEntity> findByEmail(String email);
}
package com.springboot.app.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.auth.models.entity.Rol;

public interface RolDAO extends JpaRepository<Rol,Long>{

}

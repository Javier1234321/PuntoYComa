package com.springboot.app.auth.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.auth.entity.RolEntity;

@Repository
public interface RolDao extends CrudRepository<RolEntity,Long> {

}

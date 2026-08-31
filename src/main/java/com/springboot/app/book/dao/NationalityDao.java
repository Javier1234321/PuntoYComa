package com.springboot.app.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.book.models.entity.Nationality;

public interface NationalityDao extends JpaRepository<Nationality,Long>{

}

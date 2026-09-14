package com.springboot.app.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.book.models.entity.SubCategory;

public interface SubCategoryDao extends JpaRepository<SubCategory,Long>{

}

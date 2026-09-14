package com.springboot.app.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.book.models.entity.Category;

public interface CategoryDao extends JpaRepository<Category,Long>{

}

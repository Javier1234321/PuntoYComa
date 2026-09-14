package com.springboot.app.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.book.models.entity.Language;

public interface LanguageDao extends JpaRepository<Language,Long>{

}

package com.springboot.app.book.dao;
import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.app.book.models.entity.Author;

public interface AuthorDao extends JpaRepository<Author,Long>{

}

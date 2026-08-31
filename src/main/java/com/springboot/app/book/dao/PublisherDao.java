package com.springboot.app.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.book.models.entity.Publisher;

public interface PublisherDao extends JpaRepository<Publisher,Long>{

}

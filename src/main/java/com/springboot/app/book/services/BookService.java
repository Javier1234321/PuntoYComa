package com.springboot.app.book.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.book.mapper.BookMapper;
import com.springboot.app.book.models.dto.BookDTO;


public interface BookService {
	public List<BookDTO> findAll();
	public Page<BookDTO> findAll(Pageable pageable);
	public void save(BookDTO t);
	public BookDTO findOne(Long id);
	public void delete(Long id);
	public List<BookDTO> search(String query);

}

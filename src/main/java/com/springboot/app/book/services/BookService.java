package com.springboot.app.book.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.book.dao.BookDao;
import com.springboot.app.book.mapper.BookMapper;
import com.springboot.app.book.models.dto.BookCreateDTO;
import com.springboot.app.book.models.dto.BookDTO;
import com.springboot.app.book.models.entity.Book;


public interface BookService {
	public List<BookDTO> findAll();
	public Page<BookDTO> findAll(Pageable pageable);
	public BookDTO save(BookCreateDTO dto);
	public BookDTO update(Long id,BookCreateDTO dto);
	public BookDTO findOne(Long id);
	public BookDTO delete(Long id);
	public Page<BookDTO> search(String query, Pageable pageable );

}

package com.springboot.app.book.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.book.dao.AuthorDao;
import com.springboot.app.book.dao.BookDao;
import com.springboot.app.book.dao.PublisherDao;
import com.springboot.app.book.mapper.BookMapper;
import com.springboot.app.book.models.dto.AuthorDTO;
import com.springboot.app.book.models.dto.BookDTO;
import com.springboot.app.book.models.dto.PublisherDTO;
import com.springboot.app.book.models.entity.Book;


@Service
public class BookServiceImpl implements BookService{
	private final BookDao bookDao;
	private final AuthorDao authorDao;
	private final PublisherDao publisherDao;


	public BookServiceImpl(BookDao bookDao, AuthorDao authorDao, PublisherDao publisherDao) {
		super();
		this.bookDao = bookDao;
		this.authorDao = authorDao;
		this.publisherDao = publisherDao;
	}


	@Override
	@Transactional(readOnly=true)
	public List<BookDTO> findAll() {
		return bookDao.findAll().stream()
				.map(BookMapper::toDTO)
				.collect(Collectors.toList());
	}


	@Override
	@Transactional(readOnly=true)
	public Page<BookDTO> findAll(Pageable pageable) {
		return bookDao.findAll(pageable).map(BookMapper::toDTO);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<BookDTO> search(String query) {
		return bookDao.search(query).stream()
				.map(BookMapper::toDTO)
				.collect(Collectors.toList());
	}


	@Override
	public void save(BookDTO t) {
		
		
	}


	@Override
	@Transactional(readOnly=true)
	public BookDTO findOne(Long id) {
		// TODO Auto-generated method stub
		return bookDao.findById(id).map(BookMapper::toDTO)
				.orElseThrow();
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	

}

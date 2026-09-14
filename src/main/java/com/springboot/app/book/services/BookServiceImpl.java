package com.springboot.app.book.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.book.dao.AuthorDao;
import com.springboot.app.book.dao.BookDao;
import com.springboot.app.book.dao.LanguageDao;
import com.springboot.app.book.dao.PublisherDao;
import com.springboot.app.book.dao.SubCategoryDao;
import com.springboot.app.book.mapper.BookMapper;
import com.springboot.app.book.models.dto.AuthorDTO;
import com.springboot.app.book.models.dto.BookCreateDTO;
import com.springboot.app.book.models.dto.BookDTO;
import com.springboot.app.book.models.dto.PublisherDTO;
import com.springboot.app.book.models.entity.Author;
import com.springboot.app.book.models.entity.Book;
import com.springboot.app.book.models.entity.Language;
import com.springboot.app.book.models.entity.Publisher;
import com.springboot.app.book.models.entity.SubCategory;


@Service
public class BookServiceImpl implements BookService{
	private final BookDao bookDao;
	private final AuthorDao authorDao;
	private final PublisherDao publisherDao;
	private final LanguageDao languageDao;
	private final SubCategoryDao subCategoryDao;


	


	public BookServiceImpl(BookDao bookDao, AuthorDao authorDao, PublisherDao publisherDao, LanguageDao languageDao, SubCategoryDao subCategoryDao) {
		super();
		this.bookDao = bookDao;
		this.authorDao = authorDao;
		this.publisherDao = publisherDao;
		this.languageDao = languageDao;
		this.subCategoryDao = subCategoryDao;
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
	@Transactional(readOnly = true)
	public Page<BookDTO> search(String query, Pageable page) {
	    return bookDao.search(query, page).map(BookMapper::toDTO);
	}
	
	@Override
	@Transactional
	public BookDTO save(BookCreateDTO dto) {

	    Author author = authorDao.findById(dto.getAuthorId())
	            .orElseThrow();

	    Publisher publisher = publisherDao.findById(dto.getPublisherId())
	            .orElseThrow();

	    Language language = languageDao.findById(dto.getLanguageId())
	            .orElseThrow();

	    SubCategory subCategory = subCategoryDao.findById(dto.getSubCategoryId())
	            .orElseThrow();

	    Book book = extracted(dto, author, publisher, language, subCategory,null);

	    Book savedBook = bookDao.save(book);
	    return BookMapper.toDTO(savedBook);
	}


	
	@Override
	@Transactional
	public BookDTO update(Long id, BookCreateDTO dto) {

	    Book book = bookDao.findById(id)
	            .orElseThrow();

	    Author author = authorDao.findById(dto.getAuthorId())
	            .orElseThrow();

	    Publisher publisher = publisherDao.findById(dto.getPublisherId())
	            .orElseThrow();

	    Language language = languageDao.findById(dto.getLanguageId())
	            .orElseThrow();

	    SubCategory subCategory = subCategoryDao.findById(dto.getSubCategoryId())
	            .orElseThrow();

	    Book bookUpdated = extracted(
	            dto,
	            author,
	            publisher,
	            language,
	            subCategory,
	            book
	    );
	    Book savedBook = bookDao.save(bookUpdated);
	    return BookMapper.toDTO(savedBook);
	}

	@Override
	@Transactional(readOnly=true)
	public BookDTO findOne(Long id) {
		// TODO Auto-generated method stub
		return bookDao.findById(id).map(BookMapper::toDTO)
				.orElseThrow();
	}


	@Override
	public BookDTO delete(Long id) {
		int updated=bookDao.updateBookStatus(id);
		Book book= bookDao.findById(id).orElseThrow();
		return BookMapper.toDTO(book);
		
	}
	private Book extracted(
	        BookCreateDTO dto,
	        Author author,
	        Publisher publisher,
	        Language language,
	        SubCategory subCategory,
	        Book book) {

	    book.setTitle(dto.getTitle());
	    book.setDescripcion(dto.getDescripcion());
	    book.setStock(dto.getStock());
	    book.setPages(dto.getPages());
	    book.setPublicado(dto.getPublicado());
	    book.setPrice(dto.getPrice());

	    book.setAuthor(author);
	    book.setPublisher(publisher);
	    book.setLanguage(language);
	    book.setSubCategory(subCategory);

	    return book;
	}

	

}

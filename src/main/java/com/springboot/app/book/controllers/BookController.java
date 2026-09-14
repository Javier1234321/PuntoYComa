package com.springboot.app.book.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.book.mapper.BookMapper;
import com.springboot.app.book.models.dto.BookCreateDTO;
import com.springboot.app.book.models.dto.BookDTO;
import com.springboot.app.book.models.entity.Book;
import com.springboot.app.book.services.BookService;
import com.springboot.app.common.ApiResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<Page<BookDTO>>> findAll(
            @PageableDefault(size = 3, sort = "title") Pageable pageable, HttpServletRequest request) {
        Page<BookDTO> resultado = bookService.findAll(pageable);

        ApiResponse<Page<BookDTO>> respuesta = new ApiResponse<>(
                HttpStatus.OK.value(),
                request.getMethod(),
                StringUtils.hasText(request.getQueryString())
                ? request.getRequestURI() + "?" + request.getQueryString()
                : request.getRequestURI(),
                resultado
        );

        return ResponseEntity.ok(respuesta);
    }
    
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Page<BookDTO>>> searchBook(
            @RequestParam String q,
            @PageableDefault(size = 3, sort = "title") Pageable pageable,
            HttpServletRequest request) {

        Page<BookDTO> resultado = bookService.search(q, pageable);

        ApiResponse<Page<BookDTO>> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                request.getMethod(),
                request.getRequestURI() + "?" + request.getQueryString(),
                resultado
        );

        return ResponseEntity.ok(apiResponse);
    }
    
    @PostMapping("/book")
    public ResponseEntity<ApiResponse<BookDTO>> add(
            @RequestBody BookCreateDTO dto,
            HttpServletRequest request) {
    	System.out.print("Entro al post");
        BookDTO bookDTO = bookService.save(dto);

        ApiResponse<BookDTO> apiResponse = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                request.getMethod(),
                request.getRequestURI(),
                bookDTO
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(apiResponse);
    }
    @PutMapping("/book/{id}")
    public ResponseEntity<ApiResponse<BookDTO>> updated(
    		@PathVariable Long id,
            @RequestBody BookCreateDTO dto,
            HttpServletRequest request) {
    	System.out.print("Entro al put");
        BookDTO bookDTO = bookService.update(id,dto);

        ApiResponse<BookDTO> apiResponse = new ApiResponse<>(
                HttpStatus.OK.value(),
                request.getMethod(),
                request.getRequestURI(),
                bookDTO
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(apiResponse);
    }
    
    @DeleteMapping("/book/{id}")
    public ResponseEntity<ApiResponse<BookDTO>> delete(
    		@PathVariable Long id,
    		HttpServletRequest request
    		){
    	System.out.println("Entro al delete");
    	BookDTO bookDTO= bookService.delete(id);
    	ApiResponse<BookDTO> apiResponse=new ApiResponse<>(
    			HttpStatus.OK.value(),
    			request.getMethod(),
    			request.getRequestURI(),
    			bookDTO
    			);
    	return ResponseEntity
    			.status(HttpStatus.CREATED)
    			.body(apiResponse);
    }
}
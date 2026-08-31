package com.springboot.app.book.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.app.book.models.dto.BookDTO;
import com.springboot.app.book.services.BookService;

@RestController
@RequestMapping("/")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<BookDTO> all() {
        List<BookDTO> books = bookService.findAll();
        System.out.println("LIBROS ENCONTRADOS: " + books.size());
        System.out.println(books);
        return books;
    }
    
    @GetMapping("/search")
    public List<BookDTO> searchBook(@RequestParam String q){
    	List<BookDTO> books=bookService.search(q);
        System.out.println("LIBROS ENCONTRADOS: " + books.size());
        System.out.println(books);
        return books;
    }
}
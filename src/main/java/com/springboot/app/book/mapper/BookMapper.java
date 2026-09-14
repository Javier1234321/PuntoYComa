package com.springboot.app.book.mapper;



import com.springboot.app.book.models.dto.BookDTO;
import com.springboot.app.book.models.entity.Book;

public class BookMapper {

    public static BookDTO toDTO(Book book) {
        if (book == null) return null;
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthorName(book.getAuthor().getFirstName()+" "+book.getAuthor().getLasttName());
        dto.setStock(book.getStock());
        dto.setPages(book.getPages());
        dto.setCategory(book.getSubCategory().getCategory().getCategory());
        dto.setSubCategory(book.getSubCategory().getSubCategory());
        dto.setPrice(book.getPrice());
        dto.setPublicationDate(book.getPublicado());
        dto.setPublisherName(book.getPublisher().getPublisher());
        return dto;
    }
}
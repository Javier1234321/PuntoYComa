package com.springboot.app.book.mapper;



import com.springboot.app.book.models.dto.BookDTO;
import com.springboot.app.book.models.entity.Book;

public class BookMapper {

    public static BookDTO toDTO(Book book) {
        if (book == null) return null;
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setDescription(book.getDescripcion());
        dto.setStock(book.getStock());
        dto.setPages(book.getPages());
        dto.setPublicationDate(book.getPublicado());
        dto.setPrice(book.getPrice());

        dto.setAuthors(AuthorMapper.toDTO(book.getAuthors()));

        dto.setPublisher(PublisherMapper.toDTO(book.getPublisher()));

        return dto;
    }
}
package com.springboot.app.book.mapper;

import com.springboot.app.book.models.dto.AuthorDTO;
import com.springboot.app.book.models.dto.AuthorSummaryDTO;
import com.springboot.app.book.models.entity.Author;

public class AuthorMapper {

    public static AuthorDTO toDTO(Author author) {
        if (author == null) return null;
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLasttName());
        dto.setBiography(author.getBiography());
        dto.setBirth(author.getBirth());
        dto.setNationality(NationalityMapper.toDTO(author.getNationality()));
        return dto;
    }

    public static AuthorSummaryDTO toSummaryDTO(Author author) {
        if (author == null) return null;
        AuthorSummaryDTO dto = new AuthorSummaryDTO();
        dto.setId(author.getId());
        dto.setFullName(author.getFirstName() + " " + author.getLasttName());
        return dto;
    }
}
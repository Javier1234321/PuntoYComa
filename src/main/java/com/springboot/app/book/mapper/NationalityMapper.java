package com.springboot.app.book.mapper;

import com.springboot.app.book.models.dto.NationalityDTO;
import com.springboot.app.book.models.entity.Nationality;

public class NationalityMapper {
    public static NationalityDTO toDTO(Nationality nationality) {
        if (nationality == null) return null;
        NationalityDTO dto = new NationalityDTO();
        dto.setId(nationality.getId());
        dto.setNationality(nationality.getNationality());
        return dto;
    }
}

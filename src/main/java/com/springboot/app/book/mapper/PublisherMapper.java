package com.springboot.app.book.mapper;

import com.springboot.app.book.models.dto.PublisherDTO;
import com.springboot.app.book.models.entity.Publisher;

public class PublisherMapper {
    public static PublisherDTO toDTO(Publisher publisher) {
        if (publisher == null) return null;
        PublisherDTO dto = new PublisherDTO();
        dto.setId(publisher.getId());
        dto.setPublisher(publisher.getPublisher());
        dto.setCreated(publisher.getCreated());
        dto.setUpdated(publisher.getUpdated());
        return dto;
    }
}

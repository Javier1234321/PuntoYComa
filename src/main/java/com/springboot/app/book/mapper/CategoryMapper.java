package com.springboot.app.book.mapper;

import com.springboot.app.book.models.dto.CategoryDTO;
import com.springboot.app.book.models.entity.Category;

public class CategoryMapper {
	public static CategoryDTO toDTO(Category category) {
		if(category==null) {return null;}
		CategoryDTO dto=new CategoryDTO();
		dto.setId(category.getId());
		dto.setCategory(category.getCategory());
		dto.setStatus(category.getStatus());
		dto.setDescription(category.getDescription());
		return dto;
	} 
}

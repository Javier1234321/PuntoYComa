package com.springboot.app.book.mapper;

import com.springboot.app.book.models.dto.SubCategoryDTO;
import com.springboot.app.book.models.entity.SubCategory;

public class SubCategoryMapper {
	public static SubCategoryDTO toDTO(SubCategory subCategory) {
		if(subCategory==null) {return null;}
		SubCategoryDTO dto= new SubCategoryDTO();
		dto.setId(subCategory.getId());
		dto.setSubCategory(subCategory.getSubCategory());
		dto.setDescription(subCategory.getDescripcion());
		dto.setCategory(CategoryMapper.toDTO(subCategory.getCategory()));
		return dto;
	}

}

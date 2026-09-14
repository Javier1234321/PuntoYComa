package com.springboot.app.book.models.dto;

import java.util.List;

import com.springboot.app.book.models.entity.Book;
import com.springboot.app.book.models.entity.Category;

public class SubCategoryDTO {
	
	private Long id;
	private String subCategory;
	private String description;
	private CategoryDTO category;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	
	
}

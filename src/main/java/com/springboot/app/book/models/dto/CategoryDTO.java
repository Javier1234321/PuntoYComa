package com.springboot.app.book.models.dto;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.book.models.entity.SubCategory;

public class CategoryDTO {
	private Long id;
	private String category;
	private String description;
	private Byte status;
	
	public CategoryDTO() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

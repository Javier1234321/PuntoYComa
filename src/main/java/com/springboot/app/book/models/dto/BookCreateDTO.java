package com.springboot.app.book.models.dto;

import java.util.Date;

public class BookCreateDTO {

    private String title;
    private String descripcion;
    private int stock;
    private int pages;
    private Date publicado;
    private float price;

    private Long authorId;
    private Long publisherId;
    private Long languageId;
    private Long subCategoryId;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public Date getPublicado() {
		return publicado;
	}
	public void setPublicado(Date publicado) {
		this.publicado = publicado;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public Long getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}
	public Long getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}
	public Long getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

    
}

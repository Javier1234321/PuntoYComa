package com.springboot.app.book.models.dto;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"id", "title", "authors", "publisher", "subCategory", "price", "stock", "pages", "publicationDate"})
public class BookDTO {
	
	    private Long id;
	    private String title;
	    private String authorName;      
	    private String publisherName;   
	    private String category;        
	    private String subCategory;     
	    private float price;
	    private Integer stock;
	    private Integer pages;
	    private Date publicationDate;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthorName() {
			return authorName;
		}
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
		public String getPublisherName() {
			return publisherName;
		}
		public void setPublisherName(String publisherName) {
			this.publisherName = publisherName;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getSubCategory() {
			return subCategory;
		}
		public void setSubCategory(String subCategory) {
			this.subCategory = subCategory;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public Integer getStock() {
			return stock;
		}
		public void setStock(Integer stock) {
			this.stock = stock;
		}
		public Integer getPages() {
			return pages;
		}
		public void setPages(Integer pages) {
			this.pages = pages;
		}
		public Date getPublicationDate() {
			return publicationDate;
		}
		public void setPublicationDate(Date publicationDate) {
			this.publicationDate = publicationDate;
		}
	    
	
	
}

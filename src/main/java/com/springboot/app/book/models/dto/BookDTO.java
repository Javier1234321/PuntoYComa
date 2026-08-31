package com.springboot.app.book.models.dto;

import java.util.Date;

public class BookDTO {
    private Long id;
    private String title;
    private String description;
    private int stock;
    private int pages;
    private Date publicationDate;
    private float price;
    private AuthorDTO author;
    private PublisherDTO publisher;
    
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public AuthorDTO getAuthors() {
		return author;
	}
	public void setAuthors(AuthorDTO author) {
		this.author = author;
	}
	public PublisherDTO getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherDTO publisher) {
		this.publisher = publisher;
	}
}

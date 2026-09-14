package com.springboot.app.book.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name="tbl_book")
public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "i_id_book")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "v_title")
	String title;
	@Column(name = "v_description")
	String descripcion;
	
	@Column(name = "i_stock")
	int stock;
	
	@Column(name = "i_pages")
	int pages;
	
	@Column(name = "d_publication")
	Date publicado;
	
	@Column(name = "m_price")
	float price;
	
	@Column(name = "dt_created_at")
	Date created;
	
	@Column(name = "dt_updated_at")
	Date updated;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "i_id_author")
	private Author author;  
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="i_id_publisher")
	private Publisher publisher;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="i_id_language")
	private Language language;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="i_id_sub_category")
	private SubCategory subCategory;
	
	public Author getAuthors() {
		return author;
	}

	public void setAuthors(Author author) {
		this.author = author;
	}

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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	
	
}

package com.springboot.app.book.models.entity;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="cat_sub_category")
public class SubCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="i_id_sub_category")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="v_sub_category")
	private String subCategory;
	
	@Column(name="t_description")
	private String descripcion;
	
	@Column(name="b_status")
	private Byte estatus;
	
	@ManyToOne
	@JoinColumn(name="i_id_category")
	private Category category;
	
	@OneToMany(mappedBy="subCategory")
	private Set<Book> books;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Byte getEstatus() {
		return estatus;
	}

	public void setEstatus(Byte estatus) {
		this.estatus = estatus;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

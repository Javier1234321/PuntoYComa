package com.springboot.app.book.models.entity;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name="cat_category")
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="i_id_category")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="v_category")
	private String category;
	
	@Column(name="t_description")
	private String description;
	
	@Column(name="b_status")
	private Byte status;
	
	
	@OneToMany(mappedBy = "category")
	private List<SubCategory> subCategories;


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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Byte getStatus() {
		return status;
	}


	public void setStatus(Byte status) {
		this.status = status;
	}

	

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}


	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

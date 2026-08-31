package com.springboot.app.book.models.dto;

import java.util.Date;

public class AuthorDTO {
 private Long id;
 private String firstName;
 private String lastName;
 private String biography;
 private Date birth;
 private NationalityDTO nationality;
 public Long getId() {
	return id;
 }
 public void setId(Long id) {
	this.id = id;
 }
 public String getFirstName() {
	return firstName;
 }
 public void setFirstName(String firstName) {
	this.firstName = firstName;
 }
 public String getLastName() {
	return lastName;
 }
 public void setLastName(String lastName) {
	this.lastName = lastName;
 }
 public String getBiography() {
	return biography;
 }
 public void setBiography(String biography) {
	this.biography = biography;
 }
 public Date getBirth() {
	return birth;
 }
 public void setBirth(Date birth) {
	this.birth = birth;
 }
 public NationalityDTO getNationality() {
	return nationality;
 }
 public void setNationality(NationalityDTO nationality) {
	this.nationality = nationality;
 }

}

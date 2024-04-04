package com.library.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Booktable")
public class Book 
{
  @Id
  @Column(name="BookID")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int BookID;
  
  @Column(name="Title")
  private String Title;
  
  @Column(name="Author")
  private String Author;
  
  @Column(name="Published_Year")
  private int Published_Year;
  
  @Column(name="Available_Copies")
  private int Available_Copies;
  
  @ManyToOne
  @JoinColumn(name = "CategoryID")
  private CategoryDetails categoryDetails;

public int getBookID() {
	return BookID;
}

public void setBookID(int bookID) {
	BookID = bookID;
}

public String getTitle() {
	return Title;
}

public void setTitle(String title) {
	Title = title;
}

public String getAuthor() {
	return Author;
}

public CategoryDetails getCategoryDetails() {
	return categoryDetails;
}

public void setCategoryDetails(CategoryDetails categoryDetails) {
	this.categoryDetails = categoryDetails;
}

public void setAuthor(String author) {
	Author = author;
}

public int getPublished_Year() {
	return Published_Year;
}

public void setPublished_Year(int published_Year) {
	Published_Year = published_Year;
}

public int getAvailable_Copies() {
	return Available_Copies;
}

public void setAvailable_Copies(int available_Copies) {
	Available_Copies = available_Copies;
}



public Book(int bookID, String title, String author, int published_Year, int available_Copies,
		CategoryDetails categoryDetails) {
	super();
	BookID = bookID;
	Title = title;
	Author = author;
	Published_Year = published_Year;
	Available_Copies = available_Copies;
	this.categoryDetails = categoryDetails;
}

public Book() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Book [BookID=" + BookID + ", Title=" + Title + ", Author=" + Author + ", Published_Year=" + Published_Year
			+ ", Available_Copies=" + Available_Copies + ", categoryDetails=" + categoryDetails + "]";
}
}
package com.library.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name="CategoryTable")
public class CategoryDetails 
{
	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="CategoryID")
	 private int CategoryID;
	 
	 @Column(name="CategoryName")
	 private String CategoryName;
	 
	 @OneToMany(mappedBy = "categoryDetails",cascade=CascadeType.ALL,orphanRemoval=true)
	 private List<Book> books;

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public CategoryDetails(int categoryID, String categoryName, List<Book> books) {
		super();
		CategoryID = categoryID;
		CategoryName = categoryName;
		this.books = books;
	}

	public CategoryDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CategoryDetails [CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + ", books=" + books
				+ "]";
	}	 
}

		

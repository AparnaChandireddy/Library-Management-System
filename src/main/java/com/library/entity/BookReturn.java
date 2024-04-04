package com.library.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="BookReturn")
public class BookReturn
{
	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="ReturnID")
	 private int ReturnID;

     @Column(name="ReturnDate")
	 private Date ReturnDate;
     
	 @Column(name="Fine")
	 private int Fine;
	 
	 @Version
	    private Long version;
	 
	  @OneToOne
	    @JoinColumn(name = "TransactionID")
	    private BookIssue bookIssue;

	public int getReturnID() {
		return ReturnID;
	}

	public void setReturnID(int returnID) {
		ReturnID = returnID;
	}

	public Date getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}

	public int getFine() {
		return Fine;
	}

	public void setFine(int fine) {
		Fine = fine;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public BookIssue getBookIssue() {
		return bookIssue;
	}

	public void setBookIssue(BookIssue bookIssue) {
		this.bookIssue = bookIssue;
	}

	public BookReturn(int returnID, Date returnDate, int fine, Long version, BookIssue bookIssue) {
		super();
		ReturnID = returnID;
		ReturnDate = returnDate;
		Fine = fine;
		this.version = version;
		this.bookIssue = bookIssue;
	}

	public BookReturn() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookReturn [ReturnID=" + ReturnID + ", ReturnDate=" + ReturnDate + ", Fine=" + Fine + ", version="
				+ version + ", bookIssue=" + bookIssue + "]";
	}
}

	
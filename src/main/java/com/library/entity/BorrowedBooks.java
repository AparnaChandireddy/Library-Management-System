package com.library.entity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BorrowedBooks")
public class BorrowedBooks 
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="BorrowedID")
	private int BorrowedID;
	
    @Column(name="BookID")
    private int BookID;
   
    @Column(name="BorrowedDate")
    private Date BorrowedDate;
    @Column(name="ReturnDate")
    private Date ReturnDate;
    
    
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "membersID")
    private Members members;
    
    public BorrowedBooks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBorrowedID() {
		return BorrowedID;
	}

	public void setBorrowedID(int borrowedID) {
		BorrowedID = borrowedID;
	}

	public int getBookID() {
		return BookID;
	}

	public void setBookID(int bookID) {
		BookID = bookID;
	}

	
	public Date getBorrowedDate() {
		return BorrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		BorrowedDate = borrowedDate;
	}

	public Date getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}

	
	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	public BorrowedBooks(int borrowedID, int bookID, int membersID, Date borrowedDate, Date returnDate,
			Members members) {
		super();
		BorrowedID = borrowedID;
		BookID = bookID;
	
		BorrowedDate = borrowedDate;
		ReturnDate = returnDate;
		
		this.members = members;
	}

	@Override
	public String toString() {
		return "BorrowedBooks [BorrowedID=" + BorrowedID + ", BookID=" + BookID + ", BorrowedDate=" + BorrowedDate
				+ ", ReturnDate=" + ReturnDate + ", members=" + members + "]";
	}

	
}

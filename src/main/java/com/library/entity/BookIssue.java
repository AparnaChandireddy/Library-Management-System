package com.library.entity;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BookIssue")
public class BookIssue 
{
	 @Id
	 @Column(name="TransactionID")
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int TransactionID;
	 
	 @Column(name="IssueDate")
	 private Date IssueDate;
	 
     @Column(name="DueDate")
	 private Date DueDate;
     
	 @Column(name="BorrowedID", insertable = false, updatable = false)
	 private String BorrowedID;
	 
	 @Column(name="Status")
	 private String Status;
	 

	    @OneToOne(mappedBy = "bookIssue",cascade=CascadeType.ALL)
	    private BookReturn bookReturn;

       
		public BookIssue() {
			super();
			// TODO Auto-generated constructor stub
		}


		public int getTransactionID() {
			return TransactionID;
		}


		public void setTransactionID(int transactionID) {
			TransactionID = transactionID;
		}


		public Date getIssueDate() {
			return IssueDate;
		}


		public void setIssueDate(Date issueDate) {
			IssueDate = issueDate;
		}


		public Date getDueDate() {
			return DueDate;
		}


		public void setDueDate(Date dueDate) {
			DueDate = dueDate;
		}


		public String getBorrowedID() {
			return BorrowedID;
		}


		public void setBorrowedID(String borrowedID) {
			BorrowedID = borrowedID;
		}


		public String getStatus() {
			return Status;
		}


		public void setStatus(String status) {
			Status = status;
		}


		public BookReturn getBookReturn() {
			return bookReturn;
		}


		public void setBookReturn(BookReturn bookReturn) {
			this.bookReturn = bookReturn;
		}


		@Override
		public String toString() {
			return "BookIssue [TransactionID=" + TransactionID + ", IssueDate=" + IssueDate + ", DueDate=" + DueDate
					+ ", BorrowedID=" + BorrowedID + ", Status=" + Status + ", bookReturn=" + bookReturn + "]";
		}


		public BookIssue(int transactionID, Date issueDate, Date dueDate, String borrowedID, String status,
				BookReturn bookReturn) {
			super();
			TransactionID = transactionID;
			IssueDate = issueDate;
			DueDate = dueDate;
			BorrowedID = borrowedID;
			Status = status;
			this.bookReturn = bookReturn;
		}
}

		

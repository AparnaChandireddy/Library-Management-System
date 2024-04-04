package com.library.entity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Members")
public class Members 
{
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name="MembersID")
	  private int MembersID;
	  @Column(name="FirstName")
	  private String FirstName;
	  @Column(name="LastName")
	  private String LastName;
	  @Column(name="EmailID")
	  private String EmailID;
	  

      @OneToMany(mappedBy = "members",cascade=CascadeType.ALL)
	  private List<BorrowedBooks> borrowedBooks;
      
      public Members() {
  		super();
  	}

	public int getMembersID() {
		return MembersID;
	}


	public void setMemberID(int membersID) {
		MembersID = membersID;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getEmailID() {
		return EmailID;
	}


	public void setEmailID(String emailID) {
		EmailID = emailID;
	}


	public List<BorrowedBooks> getBorrowedBooks() {
		return borrowedBooks;
	}


	public void setBorrowedBooks(List<BorrowedBooks> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}


	public Members(int membersID, String firstName, String lastName, String emailID, List<BorrowedBooks> borrowedBooks) {
		super();
		MembersID = membersID;
		FirstName = firstName;
		LastName = lastName;
		EmailID = emailID;
		this.borrowedBooks = borrowedBooks;
	}

	@Override
	public String toString() {
		return "Members [MembersID=" + MembersID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", EmailID="
				+ EmailID + ", borrowedBooks=" + borrowedBooks + "]";
	}
}

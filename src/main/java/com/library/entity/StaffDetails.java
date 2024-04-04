package com.library.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="StaffDetails")
public class StaffDetails
{
	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="StaffID")
	 private int StaffID;
	 @Column(name="StaffName")
	 private String StaffName;
     @Column(name="Password")
	 private String Password;
	 @Column(name="Designation")
	 private String Designation;
	private StaffDetails staffDetails;
	 
	
	 public StaffDetails() {
			super();
			// TODO Auto-generated constructor stub
		}

	public int getStaffID() {
		return StaffID;
	}

	public void setStaffID(int staffID) {
		StaffID = staffID;
	}

	public String getStaffName() {
		return StaffName;
	}

	public void setStaffName(String staffName) {
		StaffName = staffName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public StaffDetails getStaffDetails() {
		return staffDetails;
	}

	public void setStaffDetails(StaffDetails staffDetails) {
		this.staffDetails = staffDetails;
	}

	public StaffDetails(int staffID, String staffName, String password, String designation, StaffDetails staffDetails) {
		super();
		StaffID = staffID;
		StaffName = staffName;
		Password = password;
		Designation = designation;
		this.staffDetails = staffDetails;
	}

	@Override
	public String toString() {
		return "StaffDetails [StaffID=" + StaffID + ", StaffName=" + StaffName + ", Password=" + Password
				+ ", Designation=" + Designation + ", staffDetails=" + staffDetails + "]";
	}
}

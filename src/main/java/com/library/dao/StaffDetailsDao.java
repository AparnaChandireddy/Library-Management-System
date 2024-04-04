package com.library.dao;
import com.library.entity.StaffDetails;
import java.util.List;
public interface StaffDetailsDao 
{
	 void addStaff(StaffDetails staff);
     void updateStaff(StaffDetails staff);
     void deleteStaff(int staffID);
     StaffDetails getStaffById(int staffID);
     List<StaffDetails> getAllStaff();
}

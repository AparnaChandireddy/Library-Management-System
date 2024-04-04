package com.library.dao;
import com.library.entity.Members;
import java.util.List;
public interface MembersDao 
{
	 void addMember(Members member);
	 void updateMember(Members member);
	 void deleteMember(int memberId);
	 Members getMemberById(int memberId);
     List<Members> getAllMembers();

}

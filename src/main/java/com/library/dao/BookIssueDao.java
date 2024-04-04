package com.library.dao;
import java.util.List;
import com.library.entity.BookIssue;

public interface BookIssueDao
{
	    void save(BookIssue bookIssue); 
	    void update(BookIssue bookIssue);
	    void delete(BookIssue bookIssue);
	    BookIssue getById(String transactionId);
	    List<BookIssue> getAll();
		void setTransactionID(int transactionID);
		void setIssueDate(int issueDate);
		void setStatus(String status);
		void setDueDate(int dueDate);
	
}

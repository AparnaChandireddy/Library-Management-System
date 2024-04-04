package com.library.dao;
import com.library.entity.BorrowedBooks;
import java.util.List;
public interface BorrowedBooksDao
{
	 void addBorrowedBook(BorrowedBooks borrowedBooks);
	 void updateBorrowedBook(BorrowedBooks borrowedBooks);
	 void deleteBorrowedBook(String borrowedID);
     BorrowedBooks getBorrowedBookById(String borrowedID);
     List<BorrowedBooks> getAllBorrowedBooks();
}

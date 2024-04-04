package com.library.dao;
import java.util.List;
import com.library.entity.Book;

public interface BookDao
{
	void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(String bookID);
    Book getBookById(String bookID);
    List<Book> getAllBooks();
}

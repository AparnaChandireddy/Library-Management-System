package com.library.dao;
import java.util.List;
import com.library.entity.BookReturn;

public interface BookReturnDao 
{
    void addBookReturn(BookReturn bookReturn);
    void updateBookReturn(BookReturn bookReturn);
    void deleteBookReturn(String returnID);
    BookReturn getBookReturnById(String returnID);
    List<BookReturn> getAllBookReturns();
}
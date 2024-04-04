package com.library.daoimpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.library.dao.BookDao;
import com.library.entity.Book;
import com.library.util.HibernateUtil;

public class BookDaoImpl implements BookDao {
	Transaction transaction = null;
    Session session=null;

    private SessionFactory sessionFactory;
    public BookDaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

	@Override
    public void addBook(Book book) {
        try
        {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
        	session.close();
        }
    }

    @Override
    public void updateBook(Book book) {
       
       
        try {
        	 session =  HibernateUtil.getSession(); 
        
            transaction = session.beginTransaction();
            session.saveOrUpdate(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
        	session.close();
        }
    }

    @Override
    public void deleteBook(String bookID) {
       
        try {
         session =  HibernateUtil.getSession(); 
         transaction = session.beginTransaction();
            Book book = session.get(Book.class, bookID);
            if (book != null) {
                session.delete(book);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
        	session.close();
        }
    }

    @Override
    public Book getBookById(String bookID) {
        try  {
        	 session =  HibernateUtil.getSession();
            return session.get(Book.class, bookID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally
        {
        	session.close();
        }
    }

    @Override
    public List<Book> getAllBooks() {
        try  
        {
           session =  HibernateUtil.getSession();
            Query<Book> query = session.createQuery("FROM Book", Book.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally
        {
        	session.close();
        }
    }
}


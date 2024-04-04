package com.library.daoimpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.library.dao.BorrowedBooksDao;
import com.library.entity.BorrowedBooks;
import com.library.util.HibernateUtil;

public class BorrowedBooksDaoImpl implements BorrowedBooksDao
{
	 Transaction transaction = null;
	    Session session = null;

    @Override
    public void addBorrowedBook(BorrowedBooks borrowedBooks) 
    
    {
    	  try 
        {
    	    session = HibernateUtil.getSession();
            session.beginTransaction();
            session.saveOrUpdate(borrowedBooks);
            session.getTransaction().commit();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    	  finally
          {
          	session.close();
          }
    }

    @Override
    public void updateBorrowedBook(BorrowedBooks borrowedBooks) 
    
    {
    	  try 
        {
    	    session = HibernateUtil.getSession();
            session.beginTransaction();
            session.saveOrUpdate(borrowedBooks);
            session.getTransaction().commit();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    	  finally
          {
          	session.close();
          }
    }

    @Override
    public void deleteBorrowedBook(String borrowedID) 
    {
    	  try 
        {
    	    session = HibernateUtil.getSession();
            session.beginTransaction();
            BorrowedBooks borrowedBooks = session.get(BorrowedBooks.class, borrowedID);
            if (borrowedBooks != null) {
                session.delete(borrowedBooks);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	  finally
          {
          	session.close();
          }
    }

    @Override
    public BorrowedBooks getBorrowedBookById(String borrowedID) 
    {
    	  try 
        {
    	    session = HibernateUtil.getSession();
            session.beginTransaction();
            BorrowedBooks borrowedBooks = session.get(BorrowedBooks.class, borrowedID);
            session.getTransaction().commit();
            return borrowedBooks;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    	  finally
          {
          	session.close();
          }
    }

    @Override
    public List<BorrowedBooks> getAllBorrowedBooks() 
    {
    	  try 
        {
    		session = HibernateUtil.getSession();
            session.beginTransaction();
            Query<BorrowedBooks> query = session.createQuery("FROM BorrowedBooks", BorrowedBooks.class);
            List<BorrowedBooks> borrowedBooksList = query.getResultList();
            session.getTransaction().commit();
            return borrowedBooksList;
        } 
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    	  finally
          {
          	session.close();
          }
    }
}

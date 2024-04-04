package com.library.daoimpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.library.dao.BookReturnDao;
import com.library.entity.BookReturn;
import com.library.util.HibernateUtil;

public class BookReturnDaoImpl implements BookReturnDao
{
	 Transaction transaction = null;
	    Session session = null;
	    
    @Override
    public void addBookReturn(BookReturn bookReturn) 
    {
    	  try
        {
    		  session = HibernateUtil.getSession();
    		  {
    		  transaction = session.beginTransaction();
            session.saveOrUpdate(bookReturn);
            transaction.commit();
        } 
        }
        catch (Exception e) 
        {
        	  if (transaction != null) transaction.rollback();
              throw e; // or display error message
          }
    	  finally
          {
          	session.close();
          }
    }

    @Override
    public void updateBookReturn(BookReturn bookReturn)
    {
    	  try
        {
    		   session = HibernateUtil.getSession();
    		   {
    		   transaction =session.beginTransaction();
            session.saveOrUpdate(bookReturn);
            transaction.commit();
    		   }
        }
        catch (Exception e)
        {
        	  if (transaction != null) transaction.rollback();
              throw e; // or display error message
        }
    	  finally
          {
          	session.close();
          }
    }

    @Override
    public void deleteBookReturn(String returnID)
    {
    	  try
        {
    		   session = HibernateUtil.getSession();
    		   {
    			   transaction =  session.beginTransaction();
            BookReturn bookReturn = session.get(BookReturn.class, returnID);
            if (bookReturn != null) 
            {
                session.delete(bookReturn);
            }
            transaction.commit();
    		   }
        } 
        catch (Exception e)
        {
        	   if (transaction != null) transaction.rollback();
               throw e; // or display error message
        }
    	  finally
          {
          	session.close();
          }
    }

    @Override
    public BookReturn getBookReturnById(String returnID) 
    {
    	  try 
        {
    		   session = HibernateUtil.getSession();
    		   {
    			   transaction = session.beginTransaction();
            BookReturn bookReturn = session.get(BookReturn.class, returnID);
            transaction.commit();
            return bookReturn;
    		   }
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
    public List<BookReturn> getAllBookReturns() 
    {
    	  try 
        {
    		   session = HibernateUtil.getSession();
            session.beginTransaction();
            Query<BookReturn> query = session.createQuery("FROM BookReturn", BookReturn.class);
            List<BookReturn> bookReturns = query.getResultList();
            session.getTransaction().commit();
            return bookReturns;
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


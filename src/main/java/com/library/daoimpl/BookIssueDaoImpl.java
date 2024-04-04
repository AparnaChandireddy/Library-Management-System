package com.library.daoimpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.library.dao.BookIssueDao;
import com.library.entity.BookIssue;
import com.library.util.HibernateUtil;

public class BookIssueDaoImpl implements BookIssueDao
{

    Transaction transaction = null;
    Session session = null;
    

    @Override
    public void save(BookIssue bookIssue) 
    {
    	
        try {
            session = HibernateUtil.getSession();
        {
            transaction = session.beginTransaction();
            session.saveOrUpdate(bookIssue);
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
    public void update(BookIssue bookIssue)
    {
      
        try {
        	session =HibernateUtil.getSession();
        {
        	transaction = session.beginTransaction();
            session.saveOrUpdate(bookIssue);
            transaction.commit();
        } 
        }
        catch (RuntimeException e) 
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
    public void delete(BookIssue bookIssue)
    {
       
        try {
        	session =HibernateUtil.getSession();
        {
        	transaction = session.beginTransaction();
            session.delete(bookIssue);
            transaction.commit();
        } 
        }
        catch (RuntimeException e) 
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
    public BookIssue getById(String transactionId) 
    {
    	 
        try{
        	session =HibernateUtil.getSession();
        {
            return session.get(BookIssue.class, transactionId);
        } 
        }
        finally
        {
            session.close();
        }
    }

    @Override
    public List<BookIssue> getAll() 
    {
    	 
        try{
        	session =HibernateUtil.getSession();
        {
            return session.createQuery("FROM BookIssue", BookIssue.class).list();
        } 
        }
        finally 
        {
            session.close();
        }
    }

	@Override
	public void setTransactionID(int transactionID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIssueDate(int issueDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatus(String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDueDate(int dueDate) {
		// TODO Auto-generated method stub
		
	}
}

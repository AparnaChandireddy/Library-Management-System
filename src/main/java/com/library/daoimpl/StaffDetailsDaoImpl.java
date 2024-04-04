package com.library.daoimpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.library.dao.StaffDetailsDao;
import com.library.entity.StaffDetails;
import com.library.util.HibernateUtil;

	public class StaffDetailsDaoImpl implements StaffDetailsDao 
	{
		Transaction transaction = null;
	    Session session = null;
	    
@Override
    public void addStaff(StaffDetails staff) 
    {
	  try 
	{
	    session = HibernateUtil.getSession();
	 transaction = session.beginTransaction();
		session.saveOrUpdate(staff);
		transaction.commit();
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
	public void updateStaff(StaffDetails staff) 
    {
	  try 
	{
		  session = HibernateUtil.getSession();
		 transaction = session.beginTransaction();
	    session.saveOrUpdate(staff);
	    transaction.commit();
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
    public void deleteStaff(int staffID)
    {
	  try 
	{
		  session = HibernateUtil.getSession();
	    transaction = session.beginTransaction();
	    StaffDetails staff = session.get(StaffDetails.class, staffID);
	    if (staff != null) 
	    {
	    	session.delete(staff);
	    }
	    transaction.commit();
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
	 public StaffDetails getStaffById(int staffID) 
     {
	  try 
	 {
		  session = HibernateUtil.getSession();
		 return session.get(StaffDetails.class, staffID);
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
     public List<StaffDetails> getAllStaff() 
     {
	  try 
	 {
		  session = HibernateUtil.getSession();
		 Query<StaffDetails> query = session.createQuery("FROM StaffDetails", StaffDetails.class);
	     return query.list();
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



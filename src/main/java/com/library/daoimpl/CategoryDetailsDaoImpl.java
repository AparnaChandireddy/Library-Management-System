package com.library.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.library.dao.CategoryDetailsDao;
import com.library.entity.CategoryDetails;
import com.library.util.HibernateUtil;

public class CategoryDetailsDaoImpl implements CategoryDetailsDao
{
	 Transaction transaction = null;
	    Session session = null;
@Override
   public void addCategory(CategoryDetails category) 
{
	
	  try
	 {
		 session = HibernateUtil.getSession();
	     transaction = session.beginTransaction();
	     session.saveOrUpdate(category);
	     transaction.commit();
	 } 
	 catch (Exception e) 
	 {
	       if (transaction != null)
	       {
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
    public void updateCategory(CategoryDetails category)
   {
	  
	   try 
	   {
		  session = HibernateUtil.getSession();
		   transaction = session.beginTransaction();
	        session.saveOrUpdate(category);
            transaction.commit();
	   } 
	   catch (Exception e) 
	   {
	         if (transaction != null)
	         {
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
	 public void deleteCategory(int categoryId)
   {
	  
	   try 
       {
		    session = HibernateUtil.getSession();
	         transaction = session.beginTransaction();
	         CategoryDetails category = session.get(CategoryDetails.class, categoryId);
	          if (category != null) 
	           {
	               session.delete(category);
	           }
	            transaction.commit();
	        } 
             catch (Exception e) 
           {
	           if (transaction != null)
	           {
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
	public CategoryDetails getCategoryById(int categoryId) 
  {
	  try 
	   {
		  session = HibernateUtil.getSession();
	      return session.get(CategoryDetails.class, categoryId);
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
	public List<CategoryDetails> getAllCategories() 
  {
	   try 
	    {
		   session = HibernateUtil.getSession();
	       Query<CategoryDetails> query = session.createQuery("FROM CategoryDetails", CategoryDetails.class);
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

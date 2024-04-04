package com.library.daoimpl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.library.dao.MembersDao;
import com.library.entity.Members;
import com.library.util.HibernateUtil;

public class MembersDaoImpl implements MembersDao 
{
	Transaction transaction = null;
    Session session = null;
    
@Override
   public void addMember(Members member) 
   {
	    
	    try 
	     {
	    	 session = HibernateUtil.getSession();
	          transaction = session.beginTransaction();
	          session.saveOrUpdate(member);
	          transaction.commit();
	          System.out.println("Members inserted successfully.");
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
	public void updateMember(Members member)
    {
	     try 
	     {
	    	 session = HibernateUtil.getSession();
	          transaction = session.beginTransaction();
	          session.saveOrUpdate(member);
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
	 public void deleteMember(int memberId)
     {
	     
	       try 
	       {
	    	  session = HibernateUtil.getSession();
	           transaction = session.beginTransaction();
	           Members member = session.get(Members.class, memberId);
	           if (member != null)
	           {
	               session.delete(member);
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
	  public Members getMemberById(int memberId) 
      {
	  try 
	       {
		  session = HibernateUtil.getSession();
	            return session.get(Members.class, memberId);
	       }
	       catch (Exception e) 
	       {
	           e.printStackTrace();
	           return null;
	        }
	   }
@Override
	   public List<Members> getAllMembers()
       {
	      try 
	        {
	    	  session = HibernateUtil.getSession();
	        	Query<Members> query = session.createQuery("FROM Members", Members.class);
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



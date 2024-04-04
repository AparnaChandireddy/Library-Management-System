package com.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;

import com.library.dao.BookDao;
import com.library.dao.BookIssueDao;
import com.library.dao.BookReturnDao;
import com.library.dao.BorrowedBooksDao;
import com.library.dao.CategoryDetailsDao;
import com.library.dao.MembersDao;
import com.library.dao.StaffDetailsDao;
import com.library.daoimpl.BookDaoImpl;
import com.library.daoimpl.BookIssueDaoImpl;
import com.library.daoimpl.BookReturnDaoImpl;
import com.library.daoimpl.BorrowedBooksDaoImpl;
import com.library.daoimpl.CategoryDetailsDaoImpl;
import com.library.daoimpl.MembersDaoImpl;
import com.library.daoimpl.StaffDetailsDaoImpl;
import com.library.entity.Book;
import com.library.entity.BookIssue;
import com.library.entity.BookReturn;
import com.library.entity.BorrowedBooks;
import com.library.entity.CategoryDetails;
import com.library.entity.Members;
import com.library.entity.StaffDetails;
import com.library.util.HibernateUtil;


public class App
{
	
		public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        StaffDetailsDao staffDetailsdao = new StaffDetailsDaoImpl ();
	        MembersDao membersdao = new  MembersDaoImpl();
	        CategoryDetailsDao  categoryDetailsdao  = new  CategoryDetailsDaoImpl();
	        BookDao bookdao = new BookDaoImpl();
	        BorrowedBooksDao borrowedbooksdao = new BorrowedBooksDaoImpl();
	        BookIssueDao  bookIssuedao  = new BookIssueDaoImpl();
	        BookReturnDao bookReturndao = new BookReturnDaoImpl();
	        
	        
	        int choice;
	        String input;
	        
	            System.out.println("Welcome to Library Management System, Hope you had a great day.");
	            System.out.println("1. Insert Staff Details");
	            System.out.println("2. Insert Members Details");
	            System.out.println("3. Insert Category Details");
	            System.out.println("4. Insert Book Details");
	            System.out.println("5. Insert BorrowedBooks Details");
	            System.out.println("6. Insert BookIssue Details");
	            System.out.println("7. Insert BookReturn Details");
	            System.out.println("0. Exit\n");
	            System.out.print("Enter your choice: ");
	            input = scanner.nextLine();
	            
	            if (input.matches("\\d+")) {
	                choice = Integer.parseInt(input);

	                switch (choice) {
	                    case 1: 
	                        System.out.println("Enter Staff ID: ");
	                        int id = scanner.nextInt();
	                        scanner.nextLine(); 
	                        System.out.println("Enter Staff Name: ");
	                        String name = scanner.nextLine();
	                        System.out.println("Enter Password: ");
	                        String password = scanner.nextLine();
	                        System.out.println("Enter Designation: ");
	                        String Designation = scanner.nextLine();
	                        
	                       
	                      
	                        
	                        StaffDetails staff=new StaffDetails();
	                        staff.setStaffID(id);
	                        staff.setStaffName(name);
	                        staff.setPassword(password);
	                        staff.setDesignation(Designation);
	                        if (id != 0) {
	                            staffDetailsdao.addStaff(staff);
	                            System.out.println("StaffDetails inserted successfully.");
	                        } else {
	                            System.out.println("StaffID cannot be null. Please provide a valid StaffID.");
	                        }
	                        break;
	                        

	                      // staffDetailsdao.addStaff(staff);

	                       // System.out.println("StaffDetails inserted successfully.");
	                     //   break;
	                        
	                    	case 2:
	                    	
	                    	System.out.println("Enter FirstName: ");
	                    	String firstname=scanner.next();
	                    	scanner.nextLine();
	                    	System.out.println("Enter LastName: ");
	                    	String lastname=scanner.next();
	                    	scanner.nextLine();
	                    	System.out.println("Enter Email  ");
	                    	String email=scanner.next();
	                    	scanner.nextLine();
	                    	
	                    	
	                    	Members mem=new Members();
	                    	
	                    	mem.setFirstName(firstname);
	                    	mem.setLastName(lastname);
	                    	mem.setEmailID(email);
	                    	
	                    	membersdao.addMember(mem);
	                    	
	                    	System.out.println("Members inserted successfully.");
	                    	break;
	                    	
	                    case 3:
	                    	//System.out.println("Enter CategoryID");
	                    	//int categoryid=scanner.nextInt();
	                    	System.out.println("Enter CategoryName");
	                    	String categoryName=scanner.next();
	                    	
	                    	
	                    	
	                    	CategoryDetails category = new CategoryDetails();
	                    	
	                    	//category.setCategoryID(categoryid);
	                    	category.setCategoryName(categoryName);
	                    	categoryDetailsdao.addCategory(category);
	                   
	                    	
	                    	System.out.println("CategoryDetails inserted successfully.");
	                    	break;
	                    case 4:
	 
	                    	System.out.println("Enter Title");
	                    	String title=scanner.next();
	                    	scanner.nextLine();
	                    	System.out.println("Enter Author");
	                    	String author=scanner.next();
	                    	scanner.nextLine();
	                    	System.out.println("Enter Published_Year");
	                    	int published_year=scanner.nextInt();
	                    	scanner.nextLine();
	                    	System.out.println("Enter Available_Copies");
	                    	int available_Copies=scanner.nextInt();
	                    	scanner.nextLine();
	                    	System.out.println("Enter CategoryID");
	                   int categoryID=scanner.nextInt();
	                    	Session session=HibernateUtil.getSession();
	                    	CategoryDetails categoryd=session.get(CategoryDetails.class,categoryID);
	                    	int cid=categoryd.getCategoryID();
	                    	Book book = new Book();
	                        ArrayList<Book> books=new ArrayList<Book>();
	                    	book.setTitle(title);
	                    	book.setAuthor(author);
	                    	book.setPublished_Year(published_year);
	                    	book.setAvailable_Copies(available_Copies);
	                    	book.setCategoryDetails(categoryd);
	                    	
	                    	bookdao.addBook(book);
	                    	
	                    	System.out.println("Books inserted successfully.");
	                    	break;
	                    case 5:
	                    	//System.out.println("Enter BorrowedID");
	                    	///int borrowedID=scanner.nextInt();
	                    	//scanner.nextLine();
	                    	//System.out.println("Enter BookID");
	                    	//int bookID=scanner.nextInt();
	                    	//scanner.nextLine();
	                    	System.out.println("Enter MembersID");
	                    	int membersID=scanner.nextInt();
	                    	scanner.nextLine();
	                    	System.out.println("Enter BorrowedDate");
	                    	String borroweddate=scanner.next();
	                    	scanner.nextLine();
	                    	System.out.println("Enter ReturnedDate");
	                    	String returnDate=scanner.next();
	                    	scanner.nextLine();
	                    	Session session2=HibernateUtil.getSession();
	                    	Members membersid=session2.get(Members.class,membersID);
	                    	int mid=membersid.getMembersID();
	                    	BorrowedBooks borrowedbooks = new BorrowedBooks();
	                    	//borrowedbooks.setBorrowedID(borrowedID);
	                    	borrowedbooks.setMembers(membersid);
	                      //borrowedbooks.setBorrowedDate(borrowedDate);
	                    	borrowedbooks.setBorrowedDate(new Date());// Set borrowed date with a Date object
	                      //borrowedbooks.setReturnDate(returnDate);
	                    	borrowedbooks.setReturnDate(new Date());
	                    	
	                    	session2.close();
	                    	borrowedbooksdao.addBorrowedBook(borrowedbooks);
	                    	//session2.close();
	                    	System.out.println("BorrowedBooks inserted successfully.");
	                    	break;
	                    case 6:
	                    	//System.out.println("Enter TransactionID");
	                    	//int transactionID=scanner.nextInt();
	                    	//scanner.nextLine();
	                    	System.out.println("Enter IssueDate");
	                    	String issueDate=scanner.next();
	                    	scanner.nextLine();
	                    	System.out.println("Enter  DueDate");
	                    	String dueDate=scanner.next();
	                    	scanner.nextLine();
	                    	System.out.println("Enter  Status");
	                    	String status=scanner.next();
	                    	scanner.nextLine();
	                    	//Session session1=HibernateUtil.getSession();
	                    	//BookReturn Bookd=session.get(BookReturn.class,transactionID);
	                    	//int tid=Bookd.getTransactionID();
	                    	
	                    	BookIssue bookIssue  = new BookIssue();
	                    	
	                    	bookIssue.setIssueDate(new Date()); //Set borrowed date with a Date object
	                    //	bookIssue.setTransactionID(transactionID);
	                    //	bookIssue.setIssueDate(issueDate);
	                    	bookIssue.setDueDate(new Date()); 
	                   //   bookIssue.setDueDate(dueDate);
	                    	bookIssue.setStatus(status);
	                    	
	                    	
	                    	
	                    	bookIssuedao.save(bookIssue);
	                    	
	                    	System.out.println(" BookIssue Saved successfully.");
	                    	break;
	                    case 7:
	                    	System.out.println("Enter ReturnID: ");
	                    	int returnID=scanner.nextInt();
	                    	scanner.nextLine();
	                    	System.out.println("EnterTransactionID");
	                    	int transactionID=scanner.nextInt();
	                    	scanner.nextLine();
	                    	System.out.println("Enter ReturnDate");
	                    	String returnDate1=scanner.next();
	                    	scanner.nextLine();
	                    	System.out.println("Enter Fine");
	                    	int fine  = scanner.nextInt(); 
	                    	Session session1=HibernateUtil.getSession();
					
						BookIssue Bookd=session1.get(BookIssue.class,transactionID);
	                    	int tid=Bookd.getTransactionID();
	                        
	                    	
	                    	BookReturn bookreturn = new BookReturn();
	                    	bookreturn.setReturnID(returnID);
	                    	//bookreturn.setTransactionID(Bookd);
	                     // bookReturn.setReturnDate(returnDate);
	                    	bookreturn.setReturnDate(new Date()); // Set return date with a Date object
	                    	bookreturn.setFine(fine);
	                    	bookreturn.setBookIssue(Bookd); 
	                    	
	                    	bookReturndao.addBookReturn(bookreturn);
	                    	
	                    	System.out.println("BookReturned inserted successfully.");
	                    	break;
	                    

	                    case 0:
	                        System.out.println("Exiting...");
	                        break;
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	            } else {
	                System.out.println("Please enter a valid option.");
	                choice = -1;
	            }
	        
	        scanner.close();
	    }

		
	}	                 

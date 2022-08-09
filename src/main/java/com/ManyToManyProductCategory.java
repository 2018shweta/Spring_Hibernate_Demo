package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.CategoryBean;
import com.bean.ProductBean;



public class ManyToManyProductCategory {

	
	public static void main(String[] args)
	{
		Configuration cfg= new Configuration().configure("hibernate-config.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		
		Scanner sc=new Scanner(System.in);
		
		
		while(true)
		{
			System.out.println("\1exit");
			System.out.println("\2 add category");
			System.out.println("\3 add prodyuct");
			System.out.println("Enter Choice");
			int ch=sc.nextInt();
			switch (ch) {
			case 1:System.exit(0);
				
				break;
			case 2:
				Session session=factory.openSession();
				System.out.println("Enter categoryName");
				CategoryBean category = new CategoryBean(); // transient state
				category.setCategoryName(sc.next());
				Transaction tx = session.beginTransaction();
				session.save(category);// persist
				tx.commit();
				session.close();
				break;
			case 3:
				
				Session session1=factory.openSession();
				System.out.println("Enter productName  and  price ");
				ProductBean productBean = new ProductBean();
				productBean.setProductName(sc.next());
				productBean.setPrice(sc.nextInt());
				
				while(true){
					System.out.println("Enter category in which you want to add product? 0 for exit");
					int categoryId = sc.nextInt();
					if(categoryId <= 0 ) {
						break;
					}
					CategoryBean category1 = session1.get(CategoryBean.class, categoryId);
					productBean.getCategories().add(category1);
			 			
				}
				
				Transaction tx1 = session1.beginTransaction();
				session1.save(productBean);
				tx1.commit();
				session1.close();
				break;
				
			default:System.out.println("something error");
			
				break;
			}
			
			
			
		}
		
		
	}//main
	
	
	
	
	
	
	
}//mtm

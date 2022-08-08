package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.RoleBean;
import com.bean.UserBean;

public class UserRole {

	public static void main(String[] args)
	{
		
		Configuration cfg=new Configuration().configure("hibernate-config.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		Scanner sc=new Scanner(System.in);
		
		UserBean user=new UserBean();
		System.out.println("enter values");
		user.setFirstName(sc.next());
		user.setLastName(sc.next());
		user.setEmail(sc.next());
		user.setPassword(sc.next());
		System.out.println("Enter userId??");
		int userId=sc.nextInt();
		
		
		RoleBean role=session.get(RoleBean.class, userId);
		
		user.setRole(role);
		
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		
		
	}
	
	
}

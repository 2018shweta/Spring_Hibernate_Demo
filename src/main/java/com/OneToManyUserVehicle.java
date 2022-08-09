package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.UserBean;
import com.bean.VehicleBean;

public class OneToManyUserVehicle {

	
	
	public static void main(String [] args)
	{
		Configuration cfg=new Configuration().configure("hibernate-config.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the userId?");
		int userId=sc.nextInt();
		UserBean user=session.get(UserBean.class, userId);
		
		VehicleBean v1=new VehicleBean();
		v1.setRegNo(sc.next());
		
		VehicleBean v2=new VehicleBean();
		v2.setRegNo(sc.next());
		
		
		if(user.getVehicles()==null)
		{
			List<VehicleBean> vehicles=new ArrayList<VehicleBean>();
			vehicles.add(v1);
			vehicles.add(v2);
			user.setVehicles(vehicles);
		}
		else
		{
			user.getVehicles().add(v1);
			user.getVehicles().add(v2);
		}
		
		session.save(user);
		tx.commit();
		session.close();
	}
	
	
	
}

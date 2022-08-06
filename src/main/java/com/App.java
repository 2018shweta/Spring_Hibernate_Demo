package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        //use to create session factory from given configuration
        Configuration cfg=new  Configuration().configure("hibernate-config.xml");
        
        //use to create session
        SessionFactory factory=cfg.buildSessionFactory();
        
        //use to executr query
        
        Session session=factory.openSession();
    }
}

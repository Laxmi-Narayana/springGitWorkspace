package com.lucky.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lucky.hibernate.model.Mobile;
import com.lucky.hibernate.model.UserDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("LaxmiNarayana Gellu");
        Mobile mobile1 = new Mobile();
        mobile1.setMobileName("Realme");
        Mobile mobile2 = new Mobile();
        mobile2.setMobileName("Nokia");
        userDetails.getMobile().add(mobile1);
        userDetails.getMobile().add(mobile2);
        mobile1.setUserDetails(userDetails);
        mobile2.setUserDetails(userDetails);
        try(SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();Session session = sessionFactory.openSession();) {
	        session.beginTransaction();
	        session.persist(userDetails);
	        session.persist(mobile1);
	        session.persist(mobile2);
	        session.getTransaction().commit();
        }
        catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("End of World!...");
    }
}

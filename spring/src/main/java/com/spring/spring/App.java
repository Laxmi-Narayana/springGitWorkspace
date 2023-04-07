package com.spring.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.entity.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext  context = new ClassPathXmlApplicationContext("spring_configuration.xml");
        Customer customer = context.getBean("customer1",Customer.class);
        System.out.println(customer.toString());
        ((ClassPathXmlApplicationContext)context).close();
        System.out.println( "Hello World!" );
        
    }
}

/**
 * 
 */
package com.spring.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.hibernate.dao.CustomerDAO;
import com.spring.hibernate.entity.Customer;

/**
 * @author dhiraj
 *
 */
public class Application {
	public static void main(String[] args) {
		System.out.println("main starts !!");
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ApplicationContextConfig.class);

		/**
		 * Adding Customer
		 * 
		 */
		Customer customer = new Customer();
		customer.setCname("dhiraj");
		customer.setEmail("dhiraj@com.com");
		customer.setPhone("9743854499");

		CustomerDAO customerDAO = applicationContext.getBean(CustomerDAO.class);
		System.out.println(customerDAO);
		customerDAO.addCustomer(customer);
		
		//Customer cust = customerDAO.getCustomer(2);
		//System.out.println(cust);

		System.out.println("main ends !!");

	}

}

package com.hibernate.test.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.test.entity.Address;
import com.hibernate.test.entity.Customer;
import com.hibernate.test.entity.Request;
import com.hibernate.test.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {

		try {

			Address address = new Address("Palya", "560096");
			Request r1 = new Request("Phone", "phone not working");
			Request r2 = new Request("Bell", "bell not working");

			List<Request> requests = new ArrayList<Request>();
			requests.add(r1); 
			requests.add(r2);

			Customer customer = new Customer("Dhiraj", 25,
					"dhiraj@com.com");
			customer.setAddress(address);
			r1.setCustomer(customer); // store customers in request then only it will
			r2.setCustomer(customer); // store in DB, else it will be NULL (foreign key (cid)) in request 
			//customer.setRequests(requests); // Storing requests in customer is not mandatory
			

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			session.save(r1);
			session.save(r2);
			session.save(customer);
			session.save(address);

			transaction.commit();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

package com.hibernate.test.client;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.test.entity.Address;
import com.hibernate.test.entity.Customer;
import com.hibernate.test.entity.Request;
import com.hibernate.test.util.HibernateUtil;

public class Client2 {
	public static void main(String[] args) {

		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Address address = (Address) session.load(Address.class, 2);
			Customer customer = address.getCustomer();
			System.out.println("*********");
			System.out.println(address);
			System.out.println(customer);
			System.out.println("*********");

			Collection<Request> requests = customer.getRequests();
			for (Request r : requests) {
				System.out.println(r);
				
			}

			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

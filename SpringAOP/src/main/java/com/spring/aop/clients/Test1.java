/**
 * 
 */
package com.spring.aop.clients;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.target.Accounts;

/**
 * @author dhiraj
 *
 */
public class Test1 {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Accounts accounts = context.getBean(Accounts.class);

		accounts.updateAccount();

	}

}

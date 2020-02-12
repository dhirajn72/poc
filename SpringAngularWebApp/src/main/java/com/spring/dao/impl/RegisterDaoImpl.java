/**
 * 
 */
package com.spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.spring.dao.RegisterDao;
import com.spring.entities.Register;
import com.spring.test.exceptions.UserAlreadyExistsException;
import com.spring.test.login.Login;
import com.spring.test.to.RegisterTo;

/**
 * @author dhiraj
 *
 */
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	protected HibernateTemplate hibernateTemplate;

	@Autowired
	protected HibernateTransactionManager hibernateTransactionManager;

	@Autowired
	protected PasswordEncoder passwordEncoder;

	/*
	 * @Autowired protected Register register;
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spring.dao.RegisterDao#registerUser(com.spring.test.to.RegisterTo)
	 */
	public Integer registerUser(RegisterTo to)
			throws UserAlreadyExistsException {
		Register register = new Register();
		register.setName(to.getName());
		register.setEmail(to.getEmail());
		register.setPassword(passwordEncoder.encode(to.getPassword()));

		register.setConfirmPassword(to.getConfirmPassword());
		Integer id = null;
		try {
			TransactionDefinition definition = new DefaultTransactionDefinition();
			TransactionStatus status = hibernateTransactionManager
					.getTransaction(definition);
			hibernateTemplate.save(register);
			hibernateTransactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserAlreadyExistsException("Email Already Exists :  "+to.getEmail()+"<br/>Please use different email");
		}
		return id;
	}

}

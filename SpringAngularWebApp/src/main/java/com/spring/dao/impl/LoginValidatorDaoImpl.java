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

import com.spring.dao.LoginValidatorDao;
import com.spring.dao.PasswordMismatchException;
import com.spring.entities.Register;
import com.spring.test.exceptions.EmailDoesNotExistsException;
import com.spring.test.login.Login;

/**
 * @author dhiraj
 *
 */
public class LoginValidatorDaoImpl implements LoginValidatorDao {

	@Autowired
	protected HibernateTemplate hibernateTemplate;

	@Autowired
	protected PasswordEncoder passwordEncoder;

	@Autowired
	protected HibernateTransactionManager transactionManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spring.dao.LoginValidatorDao#validateUser(com.spring.test.login.Login
	 * )
	 */
	public boolean validateUser(Login login) throws EmailDoesNotExistsException,PasswordMismatchException {
		Register register = null;
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

		try {
			register = (Register) hibernateTemplate.load(Register.class,login.getEmail());
			if (passwordEncoder.matches(login.getPassword(), register.getPassword())) {
				transactionManager.commit(transactionStatus);
				return true;
			}
			else{
				throw  new PasswordMismatchException("Password does not match");
			}
		} catch (Exception e) {
			transactionManager.rollback(transactionStatus);
			throw new EmailDoesNotExistsException("Email Does not exists :  "+ login.getEmail());
		}
	}
}

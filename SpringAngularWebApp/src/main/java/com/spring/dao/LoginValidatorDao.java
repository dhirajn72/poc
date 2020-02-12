/**
 * 
 */
package com.spring.dao;

import com.spring.test.exceptions.EmailDoesNotExistsException;
import com.spring.test.login.Login;

/**
 * @author dhiraj
 *
 */
public interface LoginValidatorDao {

	boolean validateUser(Login login) throws EmailDoesNotExistsException, PasswordMismatchException;

}

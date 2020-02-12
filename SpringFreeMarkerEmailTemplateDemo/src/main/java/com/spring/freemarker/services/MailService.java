/**
 * 
 */
package com.spring.freemarker.services;

import java.io.IOException;

import com.spring.freemarker.mail.pojo.Mail;

/**
 * @author dhiraj
 *
 */
public interface MailService {
	public void sendEmail(Mail mail) throws IOException;
}

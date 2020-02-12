package com.spring.freemarker;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.freemarker.config.ApplicationConfig;
import com.spring.freemarker.mail.pojo.Mail;
import com.spring.freemarker.services.MailService;
import com.spring.freemarker.services.impl.MailServiceImpl;
import com.spring.freemarker.utils.EmailUtils;

/**
 * @author dhiraj
 *
 */
public class Application {

	public static void main(String args[]) throws IOException {

		Mail mail = new Mail();
		mail.setMailFrom(EmailUtils.getAppProperties().getProperty("mail.from"));

		/***
		 * 
		 * This will come from DB
		 * 
		 * 
		 **/
		mail.setMailTo(EmailUtils.getAppProperties().getProperty("mail.to"));
		mail.setMailCc(EmailUtils.getAppProperties().getProperty("mail.to"));
		mail.setMailCc(EmailUtils.getAppProperties().getProperty("mail.to"));
		mail.setMailBcc(EmailUtils.getAppProperties().getProperty("mail.to"));

		mail.setMailSubject("Spring 4 - Email with FreeMarker template");
		/***
		 * 
		 * This is the name of customer, which will appear in freemarker template These
		 * values will be fetched from database
		 * 
		 ***/
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("firstName", "Dhiraj");
		model.put("lastName", "Singh");
		model.put("location", "Bangalore");
		model.put("signature", "www.com.com");
		mail.setModel(model);

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		MailService mailService = (MailService) context.getBean(MailServiceImpl.class);
		mailService.sendEmail(mail);
		context.close();
	}

}

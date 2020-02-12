/***
 * 
 * Copyright 2017 Com Software Solutions. All Rights Reserved.
 *
 *
 ***/
package com.spring.freemarker.services.impl;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.spring.freemarker.config.db.DatabaseUtils;
import com.spring.freemarker.services.MailService;
import com.spring.freemarker.utils.EmailUtils;
import com.spring.freemarker.utils.constants.KafkaConstants;
import com.spring.kafka.pojo.SmtpService;

import freemarker.template.Configuration;

/**
 * @author dhiraj
 *
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

	private static final Logger LOGGER = org.apache.log4j.Logger.getLogger(MailServiceImpl.class);

	JavaMailSender mailSender;

	@Autowired
	Configuration fmConfiguration;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spring.freemarker.services.MailService#sendEmail(com.spring.freemarker.
	 * mail.pojo.Mail)
	 * 
	 */
	public void sendEmail(SmtpService service) throws IOException {

		try {

			mailSender = DatabaseUtils.getMailSender(service);
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(service.getSubject());
			mimeMessageHelper.setFrom(service.getFrom());
			mimeMessageHelper.setTo(service.getTo());
			mimeMessageHelper.setTo("dhiraj@com.com"); // delete me

			mimeMessageHelper.setBcc(service.getBcc());
			mimeMessageHelper.setCc(service.getCc());
			service.setMailContent(geContentFromTemplate(service));
			mimeMessageHelper.setText(service.getMailContent(), true);
			mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param model
	 * @return
	 */
	public String geContentFromTemplate(SmtpService service) {
		StringBuffer content = new StringBuffer();
		try {
			LOGGER.info(
					EmailUtils.getAppProperties().getProperty(KafkaConstants.EMAIL_TEMPLATE + service.getTemplateId()));
			System.out.println("***********");
			content.append(FreeMarkerTemplateUtils.processTemplateIntoString(
					fmConfiguration.getTemplate(EmailUtils.getAppProperties()
							.getProperty(KafkaConstants.EMAIL_TEMPLATE + service.getTemplateId())),
					service.getModel()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}
}
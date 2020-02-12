/**
 * 
 */
package com.spring.freemarker.services.impl;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.spring.freemarker.mail.pojo.Mail;
import com.spring.freemarker.services.MailService;

import freemarker.template.Configuration;

/**
 * @author dhiraj
 *
 */
@Service
public class MailServiceImpl implements MailService {

	@Autowired
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
	public void sendEmail(Mail mail) throws IOException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setFrom(mail.getMailFrom());
			mimeMessageHelper.setTo(mail.getMailTo());
			mimeMessageHelper.setBcc(mail.getMailBcc());
			mimeMessageHelper.setCc(mail.getMailCc());

			mimeMessageHelper.setTo(mail.getMailTo());

			mail.setMailContent(geContentFromTemplate(mail.getModel()));
			mimeMessageHelper.setText(mail.getMailContent(), true);
			mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public String geContentFromTemplate(Map<String, Object> model) {
		StringBuffer content = new StringBuffer();

		try {
			content.append(FreeMarkerTemplateUtils
					.processTemplateIntoString(fmConfiguration.getTemplate("email-template.txt"), model));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}

}
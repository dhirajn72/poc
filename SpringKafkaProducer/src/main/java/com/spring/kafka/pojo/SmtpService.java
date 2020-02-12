/***
 * 
 * Copyright 2017 Com Software Solutions. All Rights Reserved.
 *
 *
 ***/
package com.spring.kafka.pojo;

import java.util.Arrays;
import java.util.Map;

/**
 * @author dhiraj
 *
 */
public class SmtpService {

	private int service_id;
	private String from;
	private String[] to;
	private String[] cc;
	private String[] bcc;
	private String subject;
	private Map<String, Object> model;
	private String mailContent;
	private int templateId;

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public String getMailContent() {
		return mailContent;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

	@Override
	public String toString() {
		return "SmtpService [service_id=" + service_id + ", from=" + from + ", to=" + Arrays.toString(to) + ", cc="
				+ Arrays.toString(cc) + ", bcc=" + Arrays.toString(bcc) + ", subject=" + subject + ", model=" + model
				+ ", mailContent=" + mailContent + ", templateId=" + templateId + "]";
	}

}

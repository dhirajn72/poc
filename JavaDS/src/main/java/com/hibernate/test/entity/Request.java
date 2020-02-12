package com.hibernate.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author dhiraj
 *
 */
@Entity
@Table(name = "request")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reqId;

	@Column
	private String subject;

	@Column(name = "description")
	private String desc;

	@ManyToOne
	@JoinColumn(name = "cid",referencedColumnName = "cid")
	private Customer customer;

	public Request() {
	}

	public Request(String subject, String desc) {
		this.subject = subject;
		this.desc = desc;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Request [reqId=" + reqId + ", subject=" + subject + ", desc="
				+ desc + "]";
	}

}

/**
 * 
 */
package com.spring.oxm;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author dhiraj
 *
 */

@XmlRootElement
public class Customer {

	private int cid;
	private String cname;
	private String email;
	private String phone;
	private Address address;

	/**
	 * 
	 */
	public Customer() {
	}

	public Customer(int cid, String cname, String email, String phone, Address address) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", email=" + email + ", phone=" + phone + ", address="
				+ address + "]";
	}

}

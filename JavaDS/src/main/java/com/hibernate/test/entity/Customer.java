package com.hibernate.test.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author dhiraj
 *
 */
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;

	@Column
	private String cname;

	@Column
	private int age;

	@Column
	private String emmail;

	@OneToOne
	@JoinColumn(name = "houseId", referencedColumnName = "houseId")
	private Address address;

	@OneToMany(mappedBy = "customer")
	private List<Request> requests;

	public Customer() {
	}

	public Customer(String cname, int age, String emmail) {
		super();
		this.cname = cname;
		this.age = age;
		this.emmail = emmail;
	}

	public int getId() {
		return cid;
	}

	public void setId(int id) {
		this.cid = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmmail() {
		return emmail;
	}

	public void setEmmail(String emmail) {
		this.emmail = emmail;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", age=" + age
				+ ", emmail=" + emmail + "]";
	}

}

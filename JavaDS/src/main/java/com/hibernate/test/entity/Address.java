package com.hibernate.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author dhiraj
 *
 */

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int houseId;

	@Column
	private String street;

	@Column
	private String postalCode;

	@OneToOne
	@JoinColumn(name = "houseId", referencedColumnName = "houseId")
	private Customer customer;

	public Address() {
	}

	public Address(String street, String postalCode) {
		super();
		this.street = street;
		this.postalCode = postalCode;
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [houseId=" + houseId + ", street=" + street
				+ ", postalCode=" + postalCode + "]";
	}

}

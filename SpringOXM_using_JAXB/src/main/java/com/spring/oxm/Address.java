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
public class Address {
	private String houseId;
	private String state;
	private String country;

	/**
	 * 
	 */
	public Address() {
	}

	public Address(String houseId, String state, String country) {
		super();
		this.houseId = houseId;
		this.state = state;
		this.country = country;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [houseId=" + houseId + ", state=" + state + ", country=" + country + "]";
	}

}

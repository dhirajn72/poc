/**
 * 
 */
package com.spring.aop.target;

/**
 * @author dhiraj
 *
 */

public class FundTransfer {

	public void checkBalance() {
		System.out.println("FundTransfer-checkBalance()");
	}

	public void transferBalance() {
		System.out.println("FundTransfer-transferBalance()");
	}

	public void printStatement() {
		System.out.println("FundTransfer-printStatement()");
	}

}
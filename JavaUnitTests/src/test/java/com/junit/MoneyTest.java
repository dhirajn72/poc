package com.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.junit.Money;

public class MoneyTest {

	@Test
	public void constructorShouldSetAmountAndCurrency() {
		Money money = new Money(10, "USD");
		assertEquals(10, money.getAmount());
		assertEquals("USD", money.getCurrency());
	}
}

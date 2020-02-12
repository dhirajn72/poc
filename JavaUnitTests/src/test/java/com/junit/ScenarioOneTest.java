package com.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Junit rule: ARRANGE,ACT,ASSERT
 * 
 * @author dhiraj
 *
 */
public class ScenarioOneTest {

	private final String string = "dhiraj";
	private final String reverseString = "jarihd";
	private ScenarioOne one;

	/**
	 * ACT,ASSERT
	 *  Tests <code>ScenarioOne.java</code>
	 */
	@Test
	public void reverseTest() {
		String result = one.reverse(string);
		// ASSERT
		Assert.assertEquals(reverseString, result);
	}

	/**
	 * ARRANGE
	 */
	@Before
	public void setUp() {
		one = new ScenarioOne();
	}

}

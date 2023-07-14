package com.cdac;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator c = new Calculator();
		int actualValue = c.add(10, 20);
		int expectedValue = 30;
		assertEquals(expectedValue, actualValue);
		//NO NO NO NO NO NO - we should not use println
		//System.out.println(result);
	}

	@Test
	public void testSub() {
		Calculator c = new Calculator();
		int actualValue = c.sub(10, 20);
		int expectedValue = -10;
		assertEquals(expectedValue, actualValue);
	}
}

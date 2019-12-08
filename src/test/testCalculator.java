package test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sapient.calculator.FeeEngine;

public class testCalculator {

	@Test
	public void doTaskTest() {
		FeeEngine ff = new FeeEngine();
		assertEquals(ff.doTask(), true);
	}
}

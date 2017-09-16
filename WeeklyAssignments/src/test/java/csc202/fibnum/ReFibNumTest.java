package csc202.fibnum;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReFibNumTest {
	@Test
	public void testFib1() {
		ReFibNum reFibNum = new ReFibNum();
		long fib = reFibNum.fib(7);
		assertEquals(13, fib);
	}

	@Test
	public void testFib2() {
		ReFibNum reFibNum = new ReFibNum();
		long fib = reFibNum.fib(12);
		assertEquals(144, fib);
	}

}

package cs202.fibnum.gui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComputeFibonacciTest {
	

	@Test
	public void test1(){
		ComputeFibonacci fib1 = new ComputeFibonacci();
		long fib = fib1.fib(7);
		assertEquals(13, fib);
	}
	
	@Test
	public void test2(){
		ComputeFibonacci fib2 = new ComputeFibonacci();
		long fib = fib2.fib(6);
		assertEquals(8, fib);
	}
	
	@Test
	public void test3(){
		ComputeFibonacci fib3 = new ComputeFibonacci();
		long fib = fib3.fib(12);
		assertEquals(144, fib);
	}

	


}
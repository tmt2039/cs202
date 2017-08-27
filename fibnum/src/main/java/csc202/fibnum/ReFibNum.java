package csc202.fibnum;

import java.util.Scanner;

public class ReFibNum {
	/**
	 * 
	 * Always give examples first so that you can understand the 'real' problem.
	 * 
	 * fibonacci sequence:
	 * 
	 * except 0 and 1 and 2
	 * 
	 * f(0) = 1 f(1) = 1
	 * 
	 * f(2) = f(1) + f(0) = 1 + 1 = 2 f(3) = f(2) + f(1) = 2 + 1 = 3 f(4) = f(3) +
	 * f(2) = 3 + 2 = 5 f(5) = f(4) + f(3) = 5 + 3 = 8 f(6) = f(5) + f(4) = 8 + 5 =
	 * 13 f(7) = f(6) + f(5) = 13 + 8 = 21
	 * 
	 * So the solution is: n STARTS FROM 2
	 * 
	 * f(n) = f(n-1) + f(n-2)
	 * 
	 * 
	 */
	public static void main(String[] args) {

		ReFibNum reFibNum = new ReFibNum();
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter an index for a Fibonacci number.");

		int index = scan.nextInt();

		System.out.println("The Fibonacci number at " + index + " is " + reFibNum.fib(index));
	}

	public static long fib(long index) {
		if (index == 0) {
			return 0;
		} else if (index == 1)
			return 1;
		else
			return fib(index - 1) + fib(index - 2);

	}

}

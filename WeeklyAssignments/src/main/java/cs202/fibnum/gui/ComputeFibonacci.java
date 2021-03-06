package cs202.fibnum.gui;

import java.util.Scanner;

/**
 *
 * @author Administrator
 *
 */
public class ComputeFibonacci {
	public static String response;

	public static void main(String[] args) {
		ComputeFibonacci cf = new ComputeFibonacci();
		Scanner scan = new Scanner(System.in);

		do {
			System.out.println("Enter an index for a Fibonacci number.");

			int index = scan.nextInt();

			System.out.println("The Fibonacci number at index " + index + " is " + cf.fib(index));

			System.out.println("\nDo you want to find another Fibonacci number? \n y or n");
			response = scan.next();

		} while (response.equalsIgnoreCase("y"));

	}

	public long fib(long index) {
		int fibNumMinus1 = 0;
		int fibNumMinus2 = 1;
		int fOf = 0;

		for (int x = 1; x < index; x++) {
			fOf = fibNumMinus1 + fibNumMinus2;
			fibNumMinus1 = fibNumMinus2;
			fibNumMinus2 = fOf;
		}

		return (long) fOf;
	}

}

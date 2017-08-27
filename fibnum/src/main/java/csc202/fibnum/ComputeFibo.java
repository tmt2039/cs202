package csc202.fibnum;

import java.util.Scanner;

public class ComputeFibo {


	public static void main(String[] args) {
		
		
		ComputeFibo cf = new ComputeFibo();
		Scanner scan = new Scanner(System.in);
		String response;

		do {
		System.out.println("Enter an index for a Fibonacci number.");
		int index = scan.nextInt();

		System.out.println("The fibonacci number at index " + index + " is " + cf.fib(index));
		
		System.out.println("\n do you want to do it again? \n\n y or n ");
		response = scan.next();
	} while (response.equalsIgnoreCase("y"));

	}

	public long fib(long index) {
		int fibNum1 = 0;
		int  fibNum2 = 1;
		int currentNum = 0;
		for (int x = 1; x < index; x++) {
			currentNum = fibNum1 + fibNum2;
			fibNum1 = fibNum2;
			fibNum2 = currentNum;
		}
		return (long) currentNum;
		
		

	}

}

package ch19;

import java.util.Scanner;

public class LargestElement {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the Array length: ");
		int i = scan.nextInt();

		int w[] = new int[i];

		System.out.println(" Enter your elements: ");

		for (int x = 0; x < i; x++) {
			w[x] = scan.nextInt();
		}

		// int max = w[0];
		//
		// for (int m = 0; m<w.length; m++) {
		// if (w[m] > max) {
		// max = w[m];
		// }
		// }
		 
		int large = findLargest(w);
		System.out.println("The largest element is : " + large);

	}

	public static int findLargest(int[] w) {
		int max = w[0];

		for (int m = 0; m < w.length; m++) {
			if (w[m] > max)
				max = w[m];
		}
		return max;
	}

}

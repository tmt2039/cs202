package ch19;

import java.util.ArrayList;
import java.util.Scanner;

public class LarEleT2 {
	public static void main(String[] args) {
		ArrayList<Integer> arrayOfInts = new ArrayList<Integer>();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter array size :  ");
		int array = scan.nextInt();
		System.out.println("Enter elements :  ");
		for (int x = 0; x < array; x++) {
			int elements = scan.nextInt();
			arrayOfInts.add(elements);
		}
		System.out.println("The array  contains:");
		int arraySize = arrayOfInts.size();
		for (int position = 0; position < arraySize; position++)
			System.out.println(arrayOfInts.get(position));
	}

	public static <E extends Comparable<E>> E max(ArrayList<E> list) {
		E largest = null;

		for (E current : list) {

			if (largest == null) {
				largest = current;
			} else if (current.compareTo(largest) > 0) {
				largest = current;
			}
		}
		System.out.println("The max is : " + largest);
		return largest;

	}
}

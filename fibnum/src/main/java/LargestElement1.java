import java.util.ArrayList;

public class LargestElement1 {

	public static void main(String[] args) {
		
		 Integer[] arrayOfInts = {1, 3, 2, 66, 100, 33, 44};

//		Integer[] arrayOfInts = { 1, 3, 2, 66, 100, 33, 44 };

		// list of integer
		System.out.println("print listOfStrings ...");
		for (Integer integer : arrayOfInts) {
			System.out.println(integer);
		}

		ArrayList<Integer> a = new ArrayList<Integer>(); // blank - nothing - nada -zil.

		for (Integer integer : arrayOfInts) {
			a.add(integer);
		}

		max(a);

		

	}

	public static <E extends Comparable<E>> E max(ArrayList<E> list) {

		System.out.println("max ...");
		E max = null;
		// first outside loop set max = a null value.
		// for loop E current
		// if (max == null)
		// set max to current
		// else if (max.compareTo(current) < 0
		// then max = current
		// end loop

		// list of integer

		for (E current : list) {

			if (max == null) {
				max = current;
			} else if (current.compareTo(max) > 0) {
				max = current;
			}
		}
		System.out.println("The max is : " + max);
		return max;

	}

}

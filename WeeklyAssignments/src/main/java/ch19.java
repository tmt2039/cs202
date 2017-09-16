import java.util.ArrayList;

public class ch19 {
	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<Integer>(); 

		
		Integer[] arrayOfInts = { 1, 3, 2, 66, 100, 33, 44, 89, 809, 43 };

		
		System.out.println(" List of elements ...");
		for (Integer integer : arrayOfInts) {
			System.out.println(integer);

		}

		for (Integer integer : arrayOfInts) {
			a.add(integer);
		}

		max(a);

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

import java.util.Arrays;
import java.util.Comparator;

// arrays for the unsorted and the comparator

public class ch23 {
	
	//textbook given methods
	public static <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length - 1);
	}

	public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
		quickSort(list, 0, list.length - 1, comparator);
	}

	//test out the arrays
	public static void main(String[] args) {
		Integer[] intArray = { -2, 32, 54, 3, -98, 100, 231, 1, 43 };
		quickSort(intArray);
		System.out.println("Unsorted :" + Arrays.toString(intArray));
		printNewArray(intArray);

		String[] stringArray = { "apple", "pumpkin", "leaves", "october" };
		quickSort(stringArray);
		System.out.println("\n\nUnsorted :" + Arrays.toString(stringArray));
		printNewArray(stringArray);

		Double[] doubleArray = { 12.3, -90.4, 66.6, 10.13, 100.00, 3.90, 23.3, -89.76, 1.00 };
		quickSort(doubleArray);
		System.out.println("\n\nUnsorted :" + Arrays.toString(doubleArray));
		printNewArray(doubleArray);

		Character[] charArray = { 'f', 'z', 'd', 'm' };
		System.out.println("\n\nUnsorted :" + Arrays.toString(charArray));
		quickSort(charArray);
		printNewArray(charArray);

	}

	//comparator
	public static <E> int partition(E[] array, int first, int last, Comparator<? super E> c) {
		E pivot = array[first];
		int low = first + 1; 
		int high = last; 
		while (high > low) {
			while (low <= high && c.compare(array[low], pivot) <= 0)
				low++;

			while (low <= high && c.compare(array[high], pivot) > 0)
				high--;
			if (high > low) {
				E temp = array[high];
				array[high] = array[low];
				array[low] = temp;
			}
		}
		while (high > first && c.compare(array[high], pivot) >= 0)
			high--;
		if (c.compare(pivot, array[high]) > 0) {
			array[first] = array[high];
			array[high] = pivot;
			return high;
		} else {
			return first;
		}
	}

	public static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> c) {

		if (last > first) {
			int pivotIndex = partition(list, first, last, c);
			quickSort(list, first, pivotIndex - 1, c);
			quickSort(list, pivotIndex + 1, last, c);
		}
	}

	// comparable 
	public static <E extends Comparable<E>> int partition(E[] array, int first, int last) {
		E pivot = array[first];
		int low = first + 1; 
		int high = last;
		while (high > low) {
			while (low <= high && array[low].compareTo(pivot) <= 0)
				low++;

			while (low <= high && array[high].compareTo(pivot) > 0)
				high--;
			if (high > low) {
				E temp = array[high];
				array[high] = array[low];
				array[low] = temp;
			}
		}
		while (high > first && array[high].compareTo(pivot) >= 0)
			high--;
		if (pivot.compareTo(array[high]) > 0) {
			array[first] = array[high];
			array[high] = pivot;
			return high;
		} else {
			return first;
		}
	}

	public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {

		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	//print out the new arrays
	public static void printNewArray(Object[] list) {
		System.out.print("Sorted : ");
		for (int x = 0; x < list.length; x++) {
			System.out.print(list[x] + " ");
		}
		System.out.println();
	}

}

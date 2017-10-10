import java.util.Comparator;

public class ch23 {

	public static <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length - 1);
	}

	public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
		quickSort(list, 0, list.length - 1, comparator);
	}
	public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
		E pivot = list[first]; 
		int low = first + 1; 
		int high = last; 

		while (high > low) {
		
			while (low <= high && list[low].compareTo(pivot) <= 0) {
				low++;
				if (high > low) {
					E temp = list[high];
					list[high] = list[low];
					list[low] = temp;
				}
		}
			while (low <= high && list[high].compareTo(pivot) > 0) {
				high--;
			if (high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

			
			
		}

		while (high > first && list[high].compareTo(pivot) >= 0)
			high--;

		// Swap pivot with list[high]
		if (pivot.compareTo(list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}


	

	public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {

		if (last > first) {
			int partition = partition(list, first, last);
			quickSort(list, last, list.length + 1);
			quickSort(list, first, list.length - 1);
		}

	}

	public static <E> int partition(E[] list, int first, int last, Comparator<? super E> c) {

		E pivot = list[first]; 
		int low = first + 1; 
		int high = last; 

		while (high > low) {
	
			while (low <= high && c.compare(list[low], pivot) <= 0) {
				low++;
				if (high > low) {
					E temp = list[high];
					list[high] = list[low];
					list[low] = temp;
				}
		}
			while (low <= high && c.compare(list[high], pivot) > 0)
				high--;
			if (high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
			
		

		while (high > first && c.compare(list[high], pivot) >= 0)
			high--;

		
		if (c.compare(pivot, list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}


	public static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> c) {

		if (last > first) {
			int partition = partition(list, first, last, c);
			quickSort(list, last, list.length + 1, c);
			quickSort(list, first, list.length - 1, c);
		}

	}

	public static void print(Object[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer array[] = { 6, 8, 9, 10, 14, 20, 60, 11 };
		
		 int first = array[0];
		 int last = array.length - 1;
		quickSort(array);
		print(array);
	}

	
}

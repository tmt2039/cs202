
import java.util.*;

public class ch22 {
	public static LinkedList<Character> max = new LinkedList<Character>();
	public static Scanner s = new Scanner(System.in);
	public static String string;

	public static String stringInput() {
		System.out.println("Enter a string: ");
		string = s.nextLine();
		return string;
	}

	public static void MIOS(String string) {
		int length = string.length();
		int x, m;
		for (x = 0; x < length; x++) {
			LinkedList<Character> lList = new LinkedList<Character>();
			lList.add(string.charAt(x));
			for (m = 1; m < length; m++) {
				if (string.charAt(m) > lList.getLast()) {
					lList.add(string.charAt(m));
				}
			}
			if (lList.size() > max.size()) {
				max.clear();
				max.addAll(lList);
			} else
				lList.clear();

		}

	}

	private static void printOutNewString(LinkedList<Character> max) {
		for (Character newString : max) {
			System.out.print(newString);
		}
	}

	public static void main(String[] args) {

		stringInput();

		MIOS(string);

		printOutNewString(max);
	}

}

import java.util.Stack;

public class ch24 {

	public static void main(String[] args) {
		System.out.println("The first 50 prime numbers in descending order: ");
		Stack<Integer> stack = new Stack<Integer>();
		int numPrime = 50;
		int count = 0;
		for (int x = 2; count < numPrime; x++) {
			if (primeNum(x)) {

				stack.push(x);
				count++;

			}
		}

		for (int m = 1; !stack.isEmpty(); m++) {
			if (m % 10 == 0)
				System.out.println(stack.pop());
			else
				System.out.println(stack.pop());
		}

		System.out.println();
	}

	public static boolean primeNum(int n) {
		if (n % 2 == 0)
			return false;

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}

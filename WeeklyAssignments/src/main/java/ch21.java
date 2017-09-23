import java.util.HashSet;
import java.util.Set;

public class ch21 {
	public void union(Set<String> set1, Set<String> set2) {
		Set<String> union = new HashSet<String>(set1);
		set1.addAll(set2);
		System.out.println("union: " + union);

	}

	public void differences(Set<String> set1, Set<String> set2) {
		Set<String> differences = new HashSet<String>(set1);
		set1.removeAll(set2);
		System.out.println("differences: " + differences);
	}

	public void intersection(Set<String> set1, Set<String> set2) {
		Set<String> intersection = new HashSet<String>(set1);
		set1.retainAll(set2);
		System.out.println("intersections: " + intersection);
	}

	public void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		set1.add("George");
		set1.add("John");
		set1.add("Blake");
		set1.add("Kevin");
		set1.add("Michael");

		System.out.println("Set 1: " + set1);

		Set<String> set2 = new HashSet<String>();
		set1.add("George");
		set1.add("Katie");
		set1.add("Kevin");
		set1.add("Michelle");
		set1.add("Ryan");
		System.out.println("Set 2: " + set2);
		union(set1, set2);
		differences(set1, set2);
		intersection(set1, set2);
	}

}

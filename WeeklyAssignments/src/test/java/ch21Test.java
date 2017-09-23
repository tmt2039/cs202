import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ch21Test {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	private void hashSets1() {
		Set<String> set1 = new HashSet<String>();
		set1.add("Apple");
		set1.add("Peaches");
		set1.add("Kiwi");
		set1.add("Oranges");
		set1.add("Blueberry");
		
		Set<String> set2 = new HashSet<String>();
		set2.add("Banana");
		set2.add("Kiwi");
		set2.add("Tangerines");
		set2.add("Carrots");
		set2.add("Apple");
		
		
	}
	private void hashSets2() {
		Set<String> set1 = new HashSet<String>();
		set1.add("I");
		set1.add("Need");
		set1.add("Sleep");
		set1.add("So");
		set1.add("Tired");
		
		Set<String> set2 = new HashSet<String>();
		set2.add("I ");
		set2.add("am");
		set2.add("almost");
		set2.add("there");
		set2.add("yay");
		
		
	}
	private void hashSets7() {
		Set<String> set1 = new HashSet<String>();
		set1.add("Baseball");
		set1.add("BasketBall");
		set1.add("Soccer");
		set1.add("Football");
		set1.add("Rugby");
		
		Set<String> set2 = new HashSet<String>();
		set2.add("Cricket");
		set2.add("Football");
		set2.add("Tennis");
		set2.add("Bowling");
		set2.add("Lacross");
		
		
	}
	private void hashSets12() {
		Set<String> set1 = new HashSet<String>();
		set1.add("Almost");
		set1.add("Finished");
		set1.add("With");
		set1.add("This");
		set1.add("Assignment");
		
		Set<String> set2 = new HashSet<String>();
		set2.add("Almost");
		set2.add("there");
		set2.add("yay");
		set2.add("finally");
		set2.add("finished.");
		
		
	}
}

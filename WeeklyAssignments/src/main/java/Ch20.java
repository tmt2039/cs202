 


import java.util.*;

public class Ch20 {
public static void main (String [] args) {

	ArrayList<String> words = new ArrayList<String>();

	words.add("apple");
	words.add("banana");
	words.add("kiwi");
	words.add("cranberry");
	words.add("apple");
	
	System.out.println("Old List: ");
	System.out.println(words);
	
	Collections.sort(words);
	System.out.println("New List:");
	System.out.println(words);
	
	
	
}

}


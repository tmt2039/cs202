package model;

import dataStructure.LinkedList;
import src.SignUpController;
public class UserDB {
	public static void main(String[] args) {
		 // Create a user for strings
		 LinkedList<User> user = new LinkedList<>();
		
		 // Add elements to the user
		 user.add(); // Add it to the user
		 System.out.println("(1) " + user);
		
		 user.add(0, "Canada"); // Add it to the beginning of the user
		 System.out.println("(2) " + user);
		
		 user.add("Russia"); // Add it to the end of the user
		 System.out.println("(3) " + user);
		
		 user.addLast("France"); // Add it to the end of the user
		 System.out.println("(4) " + user);
		
		 user.add(2, "Germany"); // Add it to the user at index 2
		 System.out.println("(5) " + user);
		
		 user.add(5, "Norway"); // Add it to the user at index 5
		 System.out.println("(6) " + user);
		
		 user.add(0, "Poland"); // Same as user.addFirst("Poland")
		 System.out.println("(7) " + user);
		// Remove elements from the user
		 user.remove(0);// Same as user.remove("Poland") in this case
		 System.out.println("(8) " + user);
		
		 user.remove(2); // Remove the element at index 2
		 System.out.println("(9) " + user);
		
		 user.remove(user.size() - 1); // Remove the last element
		 System.out.print("(10) " + user + "\n(11) ");
		
		 for (String s: user)
		 System.out.print(s.toUpperCase() + " ");
		 }
		 } 
}

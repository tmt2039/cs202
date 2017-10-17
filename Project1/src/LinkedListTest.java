import java.util.ArrayList;
import java.util.List;

public class LinkedListTest {
	private static List<User> users = new ArrayList<User>();
  public static void main(String[] args) {
 SignUpController list = new SignUpController();
  list.add("firstN"); 
  System.out.println( list);
 list.add("lastN"); 
 System.out.println( list);
 list.add("sSN"); 
 System.out.println( list);
 list.add("phone number"); 
 System.out.println(list);
 list.addLast("dOB"); 
 System.out.println(list);
 list.add("gender"); 
System.out.println(list);
 list.add("email"); 
 System.out.println( list);
 list.add("username "); 
 System.out.println(list);
 list.add("password"); 
 System.out.println(list);
 list.remove(0);// 
 System.out.println(list);

 list.remove(2); 
 System.out.println(list);

 list.remove(list.size() - 1); // Remove the last element
 System.out.print(list );

 for (User s: users) {
	 
 }
 }
 } 
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class PersonClass {
/**
 * 
 * first name:
 * sysout" first name"
 * String firstN = s.nextLine();
 * 
 * last name:
 * sysout" last name"
 * String lastN = s.nextLine();
 * 
 * Gender
 * sysout" M for Male or F for female?"
 * String gender = s.nextLine();
 * 
 * if(does not contain f or m){
 * goes back to correct gender
 * }
 * 
 * Date of birthday
 * date format
 * int dOB = s.nextInt();
 * SSN
 * some type of format
 * 
 * int sSN = s.nextInt();
 * 
 */
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		
		String firstN, lastN, gender;
		int dob, ssn;
		
		System.out.println("First name: ");
		 firstN = s.nextLine();
		
		System.out.println("Last name: ");
		 lastN =s.nextLine();
		 
		 System.out.println("F for female and M for Male");
		 gender = s.nextLine();
		 
			 System.out.println("Type in date of birth");
		     dob = s.nextInt();
		     System.out.println("Type in SSN");
		     ssn = s.nextInt();
		     System.out.println("First name: " + firstN);
			 System.out.println("Last name: " + lastN);
			 System.out.println("DOB: " + dob);
			 System.out.println("SSN: " + ssn);
		 
		 
		 
	}
	
	

}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
	public static void main(String[] args) {
		// website for help with regular expression:
		// http://regexlib.com/Search.aspx 
		// Just search for the thing you need like ssn phone password etc...
		String regex = "^\\d{3}-\\d{2}-\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher regexMatcher = pattern.matcher("234-12-1234");
		System.out.println("234-12-1234" + ": " + regexMatcher.matches());
		
		regexMatcher = pattern.matcher("23-12-1234");
		System.out.println("23-12-1234" + ": " + regexMatcher.matches());


		regex = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}";
		pattern = Pattern.compile(regex);
		regexMatcher = pattern.matcher("(123) 456-7890");
		System.out.println("(123) 456-7890" + ": " + regexMatcher.matches());
		
		regexMatcher = pattern.matcher("(123) 45-7890");
		System.out.println("(123) 45-7890" + ": " + regexMatcher.matches());
		
		/**
		 * (			# Start of group
		 * 
	  	 * (?=.*\d)		#   must contains one digit from 0-9
	  	 * 
	  	 * (?=.*[a-z])		#   must contains one lowercase characters
	  	 * 
	  	 * (?=.*[A-Z])		#   must contains one uppercase characters
	  	 * 
	  	 * (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
	  	 * 
	     *			  .		#     match anything with previous condition checking
	     *
	     * {6,20}			#        length at least 6 characters and maximum of 20
		 *
		 * )	
		 * 
		 * 1aA@12aa
		 */
		
		regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		pattern = Pattern.compile(regex);
		regexMatcher = pattern.matcher("1aA@12aa");
		System.out.println("1aA@12aa" + ": " + regexMatcher.matches());
		
		regexMatcher = pattern.matcher("1aA12aa");
		System.out.println("1aA12aa" + ": " + regexMatcher.matches());
		
		regex = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
		pattern = Pattern.compile(regex);
		regexMatcher = pattern.matcher("abc@abc.com");
		System.out.println("abc@abc.com" + ": " + regexMatcher.matches());
		
		regexMatcher = pattern.matcher("abc@abccom");
		System.out.println("abc@abccom" + ": " + regexMatcher.matches());
		
		regexMatcher = pattern.matcher("abcabc.com");
		System.out.println("abcabc.com" + ": " + regexMatcher.matches());
		
		
		regex = "[A-Z][a-z]+";
		pattern = Pattern.compile(regex);
		regexMatcher = pattern.matcher("Alexandre");
		System.out.println("Alexandre" + ": " + regexMatcher.matches());
		
		regexMatcher = pattern.matcher("dbcdf");
		System.out.println("dbcdf" + ": " + regexMatcher.matches());
		
		regexMatcher = pattern.matcher("Alexandre1");
		System.out.println("Alexandre1" + ": " + regexMatcher.matches());
		
		
		// for the confirm password. just check if the two strings are equal. like
		// this: if (confirmedPassword.getText().equals(password.getText()) ...
	}
}
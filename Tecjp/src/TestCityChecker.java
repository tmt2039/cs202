import java.util.Scanner;
public class TestCityChecker {
private final Scanner scan = new Scanner(System.in);
private String city ="";

public String City() {
	System.out.println("Type in a city: ");
	city = scan.nextLine();
	
	return city;
}
}

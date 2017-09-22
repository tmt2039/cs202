import javax.swing.JOptionPane;

//Regular Expression
//
public class Password {
	public static void main(String[]args) {
	String statement = JOptionPane.showInputDialog("Enter password");
	//String pattern = "\\w+@\\w+\\.\\w+";
	// System.out.println(statement.matches(pattern));
	
	System.out.println(statement.length());
	if (statement.length()<8){
		System.out.println("Warning password must be at least 8 characters long. ");
	}

	}
}

import java.awt.Button;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
//import java.util.ArrayList;
//import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dataStructure.LinkedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SignUpController {
	@FXML
	TextField firstName;

	@FXML
	DatePicker birthdate;

	@FXML
	TextField lastName;

	@FXML
	TextField sSN;

	@FXML
	TextField gender;

	@FXML
	TextField email;

	@FXML
	TextField phoneNum;

	@FXML
	TextField userName;

	@FXML
	TextField state;

	@FXML
	TextField city;

	@FXML
	TextField address;

	@FXML
	TextField zipcode;
	@FXML
	PasswordField password;

	@FXML
	PasswordField confirmPassword;

	@FXML
	String photo;
	@FXML
	Button logInHandle;

	Stage signupStage = null;

	private static final String FILENAME = "C:\\cs202\\Project1\\userDB.cvs";
	private static FileChooser fileChooser = new FileChooser();

	private static LinkedList<Person> person = new LinkedList<Person>();

	private User testUser() {
		firstName.setText("John");
		lastName.setText("Smith");
		gender.setText("m");
		phoneNum.setText("123-123-1231");
		sSN.setText("123-123-1231");
		email.setText("getHelp@mail.com");
		password.setText("P@ssword123");
		confirmPassword.setText("P@ssword123");
		state.setText("California");
		userName.setText("user");
		address.setText("12345 123th St");
		city.setText("Gotham");
		zipcode.setText("89679");
		// x++;
		// birthdate.setValue(null).toString("11/24/1987");
		return null;

	}

	public SignUpController() {
		// System.out.println("Constructor ....");
		// Delete the FILENAME
		File file = new File(FILENAME);
		file.delete();
	}

	public void signUpLinkHandle() {
		signupStage = new Stage();

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("sign_up_page_SB.fxml"));
			Parent root = loader.load();
			signupStage.setTitle("Signup Page");
			signupStage.setScene(new Scene(root));
			signupStage.show();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	public boolean firstNameChecker(boolean checker) {
		String regex = "[A-Z a-z]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher regexMatcher = pattern.matcher(this.firstName.getText());
		if (!regexMatcher.matches()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("First name");
			alert.setContentText("No numbers or special characters.");
			alert.showAndWait();
			return false;
		}
		return true;

	}

	// check if last name is correct
	public boolean lastNameChecker() {
		boolean checker;
		String letters = "[a-zA-z]+";
		Pattern checkLetter = Pattern.compile(lastName.getText());
		Matcher regexMatcher = checkLetter.matcher(letters);
		if (lastName == null || lastName.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Last name");
			alert.setContentText("Please type in your last name");
			alert.showAndWait();
			checker = false;
		} else if (!lastName.getText().contains(letters)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Last name");
			alert.setContentText("No numbers or special characters .");
			alert.showAndWait();
			checker = false;
		} else {
			checker = true;
		}
		return checker;
	}

	public boolean cityChecker(boolean checker) {
		String regex = "[A-Z a-z]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher regexMatcher = pattern.matcher(city.getText());
		if (!regexMatcher.matches()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("City name");
			alert.setContentText("No numbers or special characters.");
			alert.showAndWait();
			return false;
		}
		return true;
	}

	public boolean addressChecker(boolean checker) {
		String[] tokens = address.getText().split(" ");
		
		if (!Pattern.matches("\\d+", tokens[0])) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Street number");
			alert.setContentText("Incorrect street number.");
			alert.showAndWait();
			return false;
		}
		
		// street name cannot be number.
		for (int i = 1; i < tokens.length; i++) {
			if (Pattern.matches("\\d+", tokens[i])) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Street name");
				alert.setContentText("Incorrect street name.");
				alert.showAndWait();
				return false;
			}
		}

		return true;
	}

	public boolean genderChecker(boolean checker) {

		if (gender.getText().equals(null)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Typed in wrong");
			alert.setContentText("Please type once.");
			alert.setContentText("M is for male and F is for female");

			alert.showAndWait();
			checker = false;
		}
		if (!gender.getText().equalsIgnoreCase("f") && !gender.getText().equalsIgnoreCase("m")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("last name typed in wrong");
			alert.setContentText("Please type in 'm' for male and 'f' for female");

			alert.showAndWait();
			checker = false;

		} else if (gender.getText().length() > 1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Typed in wrong");
			alert.setContentText("Please type once.");
			alert.setContentText("M is for male and F is for female");

			alert.showAndWait();
			checker = false;
		} else {
			checker = true;
		}
		return checker;

	}

	public boolean emailChecker(boolean checker) {
		// boolean checker;
		if (email.getText().equals(null)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Email is empty");
			alert.setContentText("Please type in your email in this format: XXX@mail.XXX");

			alert.showAndWait();
			checker = false;
		} else if (!email.getText().contains("@mail.")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Typed in email wrong");
			alert.setContentText("Please type in your email in this format: XXX@mail.XXX");

			alert.showAndWait();
			checker = false;
		} else {
			checker = true;
		}
		return checker;

	}

	public void birthDate() {
		String birthday = birthdate.getValue().toString();
	}

	public boolean sSNChecker(boolean checker) {
		if (!Pattern.matches("^\\d{3}-\\d{3}-\\d{4}$", sSN.getText())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Has letters in it");
			alert.setContentText("SSN only has numbers");
			alert.showAndWait();
			checker = false;
		} else {
			checker = true;
		}
		return checker;
	}

	public boolean phoneNumberChecker(boolean checker) {

		String letters = "[A-Z a-z]";
		Pattern checkLetter = Pattern.compile(phoneNum.getText());
		Matcher regexMatcher = checkLetter.matcher(letters);
		if (phoneNum.getText().contains(letters)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Has letters in it");
			alert.setContentText("phone numbers only has numbers");
			alert.showAndWait();
			checker = false;
		} else if (phoneNum.getText().length() > 12 || phoneNum.getText().length() < 12) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Not the right amount number");
			alert.setContentText("phone number format is: ###-###-####");
			alert.showAndWait();
			checker = false;
		} else {
			checker = true;
		}
		return checker;

	}

	public boolean zipcodeChecker(boolean checker) {

		String letters = "[A-Z a-z]";
		Pattern checkLetter = Pattern.compile(zipcode.getText());
		Matcher regexMatcher = checkLetter.matcher(letters);
		if (zipcode.getText().contains(letters)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Has letters in it");
			alert.setContentText("Zipcodes only has numbers");
			alert.showAndWait();
			checker = false;
		} else if (zipcode.getText().length() > 5 || zipcode.getText().length() < 5) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Not the right amount number");
			alert.setContentText("zipcodes format is: #####");
			alert.showAndWait();
			checker = false;
		} else {
			checker = true;
		}
		return checker;
	}

	public boolean stateChecker(boolean checker) {
		String[] states = { "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
				"Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
				"Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
				"Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
				"North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island",
				"South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
				"West Virginia", "Wisconsin", "Wyoming" };

		boolean found = false;

		for (String theState : states) {
			if (theState.equalsIgnoreCase(state.getText())) {
				found = true;
			}
		}

		if (!found) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Here are the valid states: ");
			alert.setContentText("Alabama, Alaska, Arizona, Arkansas, California\r\n"
					+ "Colorado, Connecticut, Delaware, Florida, Georgia\r\n"
					+ "Hawaii, Idaho, Illinois, Indiana, Iowa\r\n" + "Kansas, Kentucky,Louisiana, Maine, Maryland\r\n"
					+ "Massachusetts, Michigan, Minnesota, Mississippi, Missouri\r\n"
					+ "Montana, Nebraska, Nevada, New Hampshire, New Jersey\r\n"
					+ "New Mexico, New York, North Carolina, North Dakota\r\n"
					+ "Ohio, Oklahoma, Oregon, Pennsylvania, Rhode Island\r\n"
					+ "South Carolina, South Dakota, Tennessee, Texas, Utah\r\n"
					+ "Vermont, Virginia, Washington, West Virginia, Wisconsin, Wyoming");
			alert.showAndWait();
			checker = false;

		} else {
			checker = true;
		}
		return checker;

	}

	public boolean passwordChecker(boolean checker) {

		String regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		Pattern pattern = Pattern.compile(regex);
		Matcher regexMatcher = pattern.matcher(password.getText());
		if (!regexMatcher.matches()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Your password does not contain one of these items:");
			alert.setContentText("1 number\n 1 upper case letter\n 1 lower case letter\n 1 special character");
			alert.showAndWait();
			checker = false;
		} else {
			checker = true;
		}
		return checker;
	}

	public boolean confirmPasswordChecker(boolean checker) {

		if (!confirmPassword.getText().equals(password.getText())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Your confirm password does match");
			alert.setContentText("your confirm password does not match with password please try again");
			alert.showAndWait();
			checker = false;
		} else {
			checker = true;
		}
		return checker;
	}

	public void signUpButtonHandle() {
		boolean checker = true;
		testUser();
		System.out.println("signing up ...");

		System.out.println("users: " + LogInController.getUsers().size());
		cityChecker(checker);
		stateChecker(checker);
		firstNameChecker(checker);
		genderChecker(checker);
		emailChecker(checker);
		sSNChecker(checker);
		addressChecker(checker);
		phoneNumberChecker(checker);
		passwordChecker(checker);
		confirmPasswordChecker(checker);
		zipcodeChecker(checker);
		birthDate();
		// if (checker != true) {
		Person person = new Person(firstName.getText(), lastName.getText(), gender.getText(), sSN.getText(),
				birthdate.getValue().toString(), city.getText(), address.getText(), state.getText(), zipcode.getText());
		// person.setCity(city.getText());
		System.out.println("Person: " + person);
		User user = new User(userName.getText(), password.getText());
		user.setPerson(person);
		user.setEmail(email.getText());

		user.setPhoto(photo.toString());
		user.setPhone(phoneNum.getText());
		user.setPassword(password.getText());

		if (userIsInTheList(user)) {
			System.out.println("You got a duplicate.");
		} else {

			addUserToTheList(user);
			writeTheUserToTheFile(user);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("New Account");
			alert.setHeaderText("Welcome");
			alert.setContentText(firstName.getText() + " " + lastName.getText() + ", your username is: "
					+ userName.getText() + " and your password is: " + password.getText());
			alert.showAndWait();
		}
		// } else {
		// Alert alert = new Alert(AlertType.ERROR);
		// alert.setTitle("Sign Up did not work");
		// alert.setHeaderText("Error");
		// alert.setContentText("Invalid Information, please change it.");
		// alert.showAndWait();
		// }

	}

	private void StringTokenizer(User user) {
		String example = "First Name Last Name Gender SSN Birthday City	Address	ZipCode	State Email	UserName Password";
		StringTokenizer userList = new StringTokenizer(example);
		String firstN = userList.nextToken();
		// String zipcode = String.substring(userList.nextToken());
		boolean validity = Boolean.parseBoolean(userList.nextToken());
		if (validity) {
			System.out.println(example);
			System.out.println(user.toString());
			System.out.println(user.getPerson().toString());
			// System.out.println(zipcode);
		} else
			System.out.println("invalid string");
	}

	private void addUserToTheList(User newUser) {
		System.out.println("added user: " + newUser.getUserN());
		LogInController.getUsers().add(newUser);
	}

	private boolean userIsInTheList(User newUser) {
		boolean duplicated = false;
		for (User theUser : LogInController.getUsers()) {
			if (theUser.getUserN().equals(userName.getText())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Username is taken");
				alert.setContentText("Please type in a different username.");
				alert.showAndWait();
				duplicated = true;
				break;
			}
			if (theUser.getEmail().equals(email.getText())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Email is taken");
				alert.setContentText("Please type in a different email.");
				alert.showAndWait();
				duplicated = true;
				break;

			}

		}
		return duplicated;
	}

	public void writeTheUserToTheFile(User newUser) {
		System.out.println("Writing to file " + newUser.getUserN());
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			// bw = new BufferedWriter(new FileWriter(FILENAME, true)); // true mean to
			// append at the end of the file
			bw = new BufferedWriter(new FileWriter(FILENAME, true));
			bw.write(newUser.toString());
			bw.write("\r\n");
			bw.write(newUser.getPerson().toString());
			bw.write("\r\n");
			// bw.write("UserDB.xlsx");

		} catch (IOException e) {
			System.out.println("Error in opening or writing file.");
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();

			} catch (IOException ex) {
				System.out.println("Error in closing file.");
				ex.printStackTrace();
			}
		}
		System.out.println("Done");
	}

	public void browseButtonHandle() {

		fileChooser.setTitle("Open Resource File");

		File file = fileChooser.showOpenDialog(signupStage);
		if (file != null) {

			photo = file.getAbsolutePath().toString();
		}

	}

	public void loginLinkHandle() throws Exception {
		Stage logInStage = new Stage();

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Log_in_page_SB.fxml"));
			Parent root = loader.load();
			logInStage.setTitle("LogIn Page");
			logInStage.setScene(new Scene(root));
			logInStage.show();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

		// try {
		// // FXMLLoader loader = new
		// // FXMLLoader(getClass().getResource("Log_in_page_SB.fxml"));
		// //
		// // Parent root = loader.load();
		// Parent root = FXMLLoader.load(getClass().getResource("Log_in_page_SB.fxml"));
		// Stage logInStage = (Stage) (((Stage) (Node)
		// (e.getSource())).getScene().getWindow());
		//
		// logInStage.setTitle("LogIn Page");
		// logInStage.setScene(new Scene(root));
		// logInStage.show();
		// } catch (IOException ioe) {
		// System.out.println(ioe.getMessage());
		// }

	}
}

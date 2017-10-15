import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.awt.Button;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
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
	PasswordField password;

	@FXML
	PasswordField confirmPassword;

	@FXML
	TextField userNLog;

	@FXML
	PasswordField passwLog;

	@FXML
	String photo;

	Stage signupStage = null;

	private static final String FILENAME = "C:\\cs202\\Project1\\src\\text1.txt";

	private static List<User> users = new ArrayList<User>();
	private static List<Person> person = new ArrayList<Person>();

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

	public boolean firstNameChecker() {
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

	public boolean genderChecker() {
		boolean checker;
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

	public boolean emailChecker() {
		boolean checker;
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

	public boolean sSNChecker() {
		boolean checker;
		String letters = "[A-Z a-z]";
		Pattern checkLetter = Pattern.compile(sSN.getText());
		Matcher regexMatcher = checkLetter.matcher(letters);
		if (sSN.getText().contains(letters)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Has letters in it");
			alert.setContentText("SSN only has numbers");
			alert.showAndWait();
			checker = false;
		} else if (sSN.getText().length() > 12 || sSN.getText().length() < 12) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Not the right amount number");
			alert.setContentText("SSN format is: ###-###-####");
			alert.showAndWait();
			checker = false;
		} else {
			checker = true;
		}
		return checker;
	}

	public boolean phoneNumberChecker() {

		String letters = "[A-Z a-z]";
		Pattern checkLetter = Pattern.compile(phoneNum.getText());
		Matcher regexMatcher = checkLetter.matcher(letters);
		if (phoneNum.getText().contains(letters)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Has letters in it");
			alert.setContentText("phone numbers only has numbers");
			alert.showAndWait();
			return false;
		} else if (phoneNum.getText().length() > 12 || phoneNum.getText().length() < 12) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Not the right amount number");
			alert.setContentText("phone number format is: ###-###-####");
			alert.showAndWait();
			return false;
		} else
			return true;

	}

	public boolean passwordChecker() {

		String regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		Pattern pattern = Pattern.compile(regex);
		Matcher regexMatcher = pattern.matcher(password.getText());
		if (!regexMatcher.matches()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Your password does not contain one of these items:");
			alert.setContentText("1 number\n 1 upper case letter\n 1 lower case letter\n 1 special character");
			alert.showAndWait();
			return false;
		}
		return true;
	}

	public boolean confirmPasswordChecker() {

		if (!confirmPassword.getText().equals(password.getText())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Your confirm password does match");
			alert.setContentText("your confirm password does not match with password please try again");
			alert.showAndWait();
			return false;
		} else {
			return true;
		}

	}

	public void signUpButtonHandle() {
		logInButtonHandle();
		System.out.println("users: " + users.size());

		firstNameChecker();
		genderChecker();
		emailChecker();
		sSNChecker();
		phoneNumberChecker();
		passwordChecker();
		confirmPasswordChecker();
		browseButtonHandle();
		birthDate();

		Person person = new Person(firstName.getText(), lastName.getText(), gender.getText(), sSN.getText(),
				birthdate.getValue().toString());
		User user = new User(userName.getText(), password.getText());
		user.setPerson(person);
		user.setEmail(email.getText());
		user.setPhone(phoneNum.getText());
		user.setPhoto(photo.toString());

		user.setPassword(password.getText()); // more here

		boolean duplicated = false;
		for (User theUser : users) {
			if (theUser.getUserN().equals(userName.getText())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Username is taken");
				alert.setContentText("Please type in a different username.");
				alert.showAndWait();
				// duplicated = true;
				break;
			}
			if (theUser.getEmail().equals(email.getText())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Email is taken");
				alert.setContentText("Please type in a different email.");
				alert.showAndWait();
				// duplicated = true;
				break;

			}

		}
		if (!duplicated) {

			users.add(user);
			System.out.println("users: " + user);
			System.out.println("persons: " + person);
			bufferedWriter(user, person);
			bufferedReader(user, person);

		} else {

		}
	}

	public void bufferedWriter(User user, Person person) {

		BufferedWriter bw = null;
		FileWriter fw = null;
		System.out.println("fw " + fw + "\nbw " + bw);
		try {

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(user.toString());
			bw.write(person.toString());

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}

	public void bufferedReader(User user, Person person) {
		BufferedReader br = null;
		FileReader fr = null;

		try {

			
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String userString = user.toString();
			String personString = person.toString();

			while ((userString = br.readLine()) != null && (personString = br.readLine()) != null) {
				System.out.println(userString);
				System.out.println(personString);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}

	public void browseButtonHandle() {

		System.out.println("file chooser...");
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");

		File file = fileChooser.showOpenDialog(signupStage);
		if (file != null) {
			System.out.println("File: " + file.getAbsolutePath());
			photo = file.getAbsolutePath().toString();

		} else
			System.out.println("please select a jpg. file");

	}

	public void logInButtonHandle() {
		// for (User theUser : users) {
		// if (!theUser.getUserN().equals(userNLog.getText())) {
		// System.out.println("nope, username does not exist");
		//
		// } else if (theUser.getUserN().equals(passwLog.getText())) {
		// Alert alert = new Alert(AlertType.ERROR);
		// alert.setTitle("Error Dialog");
		// alert.setHeaderText("Password ");
		// alert.setContentText("Wrong password or does not exist.");
		// alert.showAndWait();
		// } else {
		// Alert alert = new Alert(AlertType.INFORMATION);
		// alert.setTitle("Information Dialog");
		// alert.setHeaderText("Welcome ");
		// alert.setContentText("Have a nice day.");
		// alert.showAndWait();
		// }
		// }
		System.out.println("currently not working at the moment :(");
	}

}

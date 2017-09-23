import java.util.regex.*;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	PasswordField password;

	@FXML
	PasswordField confirmPassword;

	Stage signupStage = null;

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

		String NotLetters = "\\d";
		Pattern checkLetter = Pattern.compile(firstName.getText());
		Matcher regexMatcher = checkLetter.matcher(NotLetters);
		boolean checker = false;
		if (firstName == null || firstName.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("First name");
			alert.setContentText("Please type in your last name");
			alert.showAndWait();
			checker = false;
		} else if (firstName.getText().contains(NotLetters)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("First name");
			alert.setContentText("No numbers or special characters .");
			alert.showAndWait();
			checker = false;
		}

		checker = true;
		//User firstName = new User (firstName.getText());

		return checker;

	}

	public boolean lastNameChecker() {
		String numS = "\\d";
		Pattern checkLetter = Pattern.compile(lastName.getText());
		Matcher regexMatcher = checkLetter.matcher(numS);
		if (lastName == null || lastName.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Last name");
			alert.setContentText("Please type in your last name");
			alert.showAndWait();
			return false;
		} else if (lastName.getText().contains(numS)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Last name");
			alert.setContentText("No numbers or special characters .");

			alert.showAndWait();
			return false;
		} else
			return true;
	}

	public void genderChecker() {

		if (gender.getText().equals(null)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Typed in wrong");
			alert.setContentText("Please type once.");
			alert.setContentText("M is for male and F is for female");

			alert.showAndWait();

		}
		if (!gender.getText().equalsIgnoreCase("f") && !gender.getText().equalsIgnoreCase("m")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("last name typed in wrong");
			alert.setContentText("Please type in 'm' for male and 'f' for female");

			alert.showAndWait();

		} else if (gender.getText().length() > 1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Typed in wrong");
			alert.setContentText("Please type once.");
			alert.setContentText("M is for male and F is for female");

			alert.showAndWait();

		}

	}

	public void emailChecker() {
		if (email.getText().equals(null)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Email is empty");
			alert.setContentText("Please type in your email in this format: XXX@mail.XXX");

			alert.showAndWait();
		} else if (!email.getText().contains("@mail.")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Typed in email wrong");
			alert.setContentText("Please type in your email in this format: XXX@mail.XXX");

			alert.showAndWait();

		}
	}

	public void sSNChecker() {
		String letters = "[A-Z a-z]";
		Pattern checkLetter = Pattern.compile(sSN.getText());
		Matcher regexMatcher = checkLetter.matcher(letters);
		if (sSN.getText().contains(letters)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Has letters in it");
			alert.setContentText("SSN only has numbers");
			alert.showAndWait();
		} else if (sSN.getText().length() > 12 || sSN.getText().length() < 12) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Not the right amount number");
			alert.setContentText("SSN format is: ###-###-####");
			alert.showAndWait();
		}
	}

	public void phoneNumberChecker() {
		String letters = "[A-Z a-z]";
		Pattern checkLetter = Pattern.compile(phoneNum.getText());
		Matcher regexMatcher = checkLetter.matcher(letters);
		if (phoneNum.getText().contains(letters)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Has letters in it");
			alert.setContentText("phone numbers only has numbers");
			alert.showAndWait();
		} else if (phoneNum.getText().length() > 12 || phoneNum.getText().length() < 12) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Not the right amount number");
			alert.setContentText("phone number format is: ###-###-####");
			alert.showAndWait();
		}
	}

	public void passwordChecker() {
		// "\\w{1,}, \\d{1,}, \\b{1,}"
		String passwordRequirement = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$ ";
		Pattern checkPassword = Pattern.compile(password.getText());
		Matcher regexMatcher = checkPassword.matcher(passwordRequirement);
		if (!password.getText().contains(passwordRequirement)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Your password does not contain one of these items:");
			alert.setContentText(
					"1 number\n 1 upper case letter\n 1 lower case letter\n 1 special character\n and at least 8 characters");
			alert.showAndWait();
		}
	}

	public void confirmPasswordChecker() {
		if (!confirmPassword.getText().matches(password.getText())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Your confirm password does match");
			alert.setContentText("your confirm password does not match with password please try again");
			alert.showAndWait();
		}
	}

	public void signUpButtonHandle() {

		firstNameChecker();
		genderChecker();
		emailChecker();
		sSNChecker();
		phoneNumberChecker();
		passwordChecker();
		confirmPasswordChecker();
		User user = new User(userName.getText(), password.getText());

	}

	public void browseButtonHandle() {
		
		//(ActionEvent actionEvent)
		// FileChooser fileChooser = new FileChooser();
		// Stage primaryStage =
		// (Stage) ( actionEvent.getSource()).getScene().getWindow();
		System.out.println("file chooser...");
		//
		// fileChooser.setTitle("Open Resource File");
		// fileChooser.showOpenDialog(signupStage);
	}
}

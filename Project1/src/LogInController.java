import java.awt.Button;
import java.awt.Component;
import java.io.IOException;

// using arraylist to store information
//import java.util.ArrayList;
import java.util.List;

import dataStructure.LinkedList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController extends Application {
	// public static List<User>;
	User theUser;
	@FXML
	TextField userNLog;

	@FXML
	PasswordField passwLog;

	@FXML
	Button logInHandle;

	private Stage logInStage;

	private Stage signUpStage;

	private static LinkedList<User> users = new LinkedList<User>();

	public void start(Stage stage) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Log_in_page_SB.fxml"));

			Parent root = loader.load();

			stage.setTitle("Login Page");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	public void logInButtonHandle() {
		System.out.println("login button is presse for " + userNLog.getText() + " / " + this.passwLog.getText());

		for (User theUser : users) {
			System.out.println("theUser:" + theUser.getUserN());
			System.out.println("thepassword:" + theUser.getPassword());

			// goes through the list if the username and password is correct
			if (theUser.getUserN().equals(userNLog.getText()) && theUser.getPassword().equals(passwLog.getText())) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText("Welcome ");
				alert.setContentText("Have a nice day.");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Wrong information ");
				alert.setContentText("Wrong password or Username.");
				alert.showAndWait();

			}
		}
	}

	public void signUpLinkHandle() {
		signUpStage = new Stage();

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("sign_up_page_SB.fxml"));
			Parent root = loader.load();
			signUpStage.setTitle("LogIn Page");
			signUpStage.setScene(new Scene(root));
			signUpStage.show();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	public static void main(String[] args) {

		launch();

	}

// using arraylist to store information
	public static LinkedList<User> getUsers() {
		return users;
	}
}

import java.awt.Button;
import java.io.IOException;

import dataStructure.LinkedList;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
	private TableView table = new TableView();

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
				showTable();
				// Alert alert = new Alert(AlertType.INFORMATION);
				// alert.setTitle("Information Dialog");
				// alert.setHeaderText("Welcome ");
				// alert.setContentText("Have a nice day.");
				// alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Dialog");
				alert.setHeaderText("Wrong information ");
				alert.setContentText("Wrong password or Username.");
				alert.showAndWait();

			}
		}
	}

	private void showTable() {
		TableColumn<User, String> firstNameCol;
		TableColumn<User, String> lastNameCol;
		TableColumn<User, String> usernameCol;
		TableColumn<User, String> addressCol;
		TableColumn<User, String> cityCol;
		TableColumn<User, String> stateCol;
		Scene scene = new Scene(new Group());
		Stage stage = new Stage();

		final Label label = new Label("Address Book");
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);

		firstNameCol = new TableColumn("First Name");
		TableColumn LastNameCol = new TableColumn("Last Name");
		TableColumn genderCol = new TableColumn("Gender");
		TableColumn AddressCol = new TableColumn("Address");
		TableColumn CityCol = new TableColumn("City");
		TableColumn StateCol = new TableColumn("State");

		table.getColumns().addAll(firstNameCol, LastNameCol, genderCol, AddressCol, CityCol, StateCol);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);
		stage.show();
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

import java.io.IOException;
//import java.class.User;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.xml.soap.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class LogInController extends Application {

	
	@FXML
	TextField userName;
	
	@FXML
	PasswordField password;
	
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
	
//	public void userNameChecker() {
//		if(!userName.getText().equals(User.userName.getText())) {
//			return false;
//			System.out.println("Username did not match");
//		}
//	}
	public void signUpLinkHandle() {
		System.out.println("UserName : " + userName.getText());
		System.out.println("Password : " + password.getText());
		User user = new User(userName.getText(),password.getText()); 
		
	}
	public static void main(String[] args) {

		launch();
	}
}

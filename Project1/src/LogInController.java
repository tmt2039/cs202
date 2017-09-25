import java.io.IOException;

//import java.class.User;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.Button;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	TextField userNLog;

	@FXML
	PasswordField passwLog;
	
	
	Button logInHandle;

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
	
	public void signUpLinkHandle()  {

	}
	
	


	public static void main(String[] args) {

		launch();
		
	}
}

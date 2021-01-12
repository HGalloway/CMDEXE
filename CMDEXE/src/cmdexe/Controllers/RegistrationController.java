package cmdexe.Controllers;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import cmdexe.CMDEXE;
import cmdexe.Database_Controller;
import cmdexe.SceneBuilder;
import cmdexe.Methods;
import cmdexe.Methods.FilesAndFolders;

public class RegistrationController {
	
	CMDEXE CMDEXE = new CMDEXE();
	
	@FXML
	public TextField Username; 
	
	@FXML
	private PasswordField Password;
	
	@FXML
	private TextField HostIP;
	
	@FXML
	private TextField HostUsername;
	
	@FXML
	private PasswordField HostPassword;
	
	@FXML
	private Label ErrorLabel;
	
	@FXML
	private Button NextButton;
	
	@FXML
	private Button BackButton;
	
	@FXML
	private void BackToWelcome(ActionEvent event) throws IOException {
		new SceneBuilder().SetScene(event, true, "Welcome.fxml", "Welcome", null);
    }
	
	@FXML
	private void SendToMain(ActionEvent event) throws SQLException, IOException {
		//Reseting the Error Label
		ResetErrorLabel();
		
		//Check for any errors
		if (CheckingIfAllFieldsFilled() == false) {
			ErrorLabel.setText("Please fill in all the fields.");
			ErrorLabel.setVisible(true);
		}
		else if (PasswordCorrectLength() == false) {
			ErrorLabel.setText("Your password isn't strong enough. Please make a stronger password.");
			ErrorLabel.setVisible(true);
		}
		else {
			//Put the data into the database
			StoreUserData();
			//Send the user to the main page
			System.out.println("Sent to main page");
		}
	}
	
	private void ResetErrorLabel() {
		ErrorLabel.setVisible(false);
		ErrorLabel.setText("");
	}
	
	private boolean CheckingIfAllFieldsFilled() {
		if (Username.getText().isEmpty() || Password.getText().isEmpty() || HostIP.getText().isEmpty() || HostUsername.getText().isEmpty() || HostPassword.getText().isEmpty()) {
			return false;
		}	
		else {
			return true; 
		}
	}
	
	private boolean PasswordCorrectLength() {
		if (Password.getText().length() > 8) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void StoreUserData() throws SQLException, IOException {
		Database_Controller DatabaseController = new Database_Controller();
		DatabaseController.InputIntoDatabase("UserInformation", "Username, Password", "'" + Username.getText()  + "','" + Password.getText() + "'");
		
		Methods Methods = new Methods();
		FilesAndFolders FilesAndFolders = Methods.new FilesAndFolders();
		FilesAndFolders.WriteToFile(System.getProperty("user.dir") + "\\src\\cmdexe", "UserInformation.info", "ServerIP=\"" + HostIP.getText() + "\"\nHostUsername=\"" + HostUsername.getText() + "\"\nHostPassword=\"" + HostPassword.getText() + "\"");

	}
}

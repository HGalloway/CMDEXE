package cmdexe.Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import cmdexe.CMDEXE;
import cmdexe.Database_Controller;
import cmdexe.SceneBuilder;
import cmdexe.Methods;
import cmdexe.Methods.FilesAndFolders;

public class RegistrationController {
	
	CMDEXE CMDEXE = new CMDEXE();
	Database_Controller DatabaseController = new Database_Controller();
	Methods Methods = new Methods();
	FilesAndFolders FilesAndFolders = Methods.new FilesAndFolders();
	
	private boolean UsernameTaken = false;
	
	@FXML
	private TextField Username; 
	
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
	private void BackToWelcome(ActionEvent event) throws IOException {
		new SceneBuilder().SetScene(event, true, "Welcome.fxml", "Welcome", null);
    }
	
	@FXML
	private void SendToMain(ActionEvent event) throws SQLException, IOException {
		//Reseting the Error Label
		ResetErrorLabel();
		
		//Check for any errors
		if (CheckingIfAllFieldsFilled() == false) {
			SetErrorLabel("Please fill in all the fields.");
		}
		else if (PasswordCorrectLength() == false) {
			SetErrorLabel("Your password isn't strong enough. Please make a stronger password.");
		}
		else {
			//Put the data into the database
			StoreUserData();
			//Send the user to the main page
			if (UsernameTaken == false) {
				System.out.println("Sent to main");
			}
		}
	}
	
	private void ResetErrorLabel() {
		ErrorLabel.setVisible(false);
		ErrorLabel.setText("");
	}
	
	private void SetErrorLabel(String LabelText) {
		ErrorLabel.setText(LabelText);
		ErrorLabel.setVisible(true);
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
		if (DatabaseController.CheckValuesInDatabase("Username", "UserInformation", "Username='" + Username.getText() + "'") != null) {
			UsernameTaken = true;
			SetErrorLabel("Username already taken");
		}
		else {
			UsernameTaken = false;
			DatabaseController.InputIntoDatabase("UserInformation", "Username, Password, HostIP, HostUsername, HostPassword", "'" + Username.getText()  + "','" + Password.getText() + "','" + HostIP.getText() + "','" + HostUsername.getText() + "','" + HostPassword.getText() + "'");
		}
	}
	
	@FXML
	private void ToLoginPage(ActionEvent event) throws IOException {
		new SceneBuilder().SetScene(event, true, "LoginNoBackButton.fxml", "Welcome", null);
	}
}

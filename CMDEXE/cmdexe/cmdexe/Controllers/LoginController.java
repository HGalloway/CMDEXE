package cmdexe.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

import cmdexe.Database_Controller;
import cmdexe.ProgramInformation;
import cmdexe.SceneBuilder;

public class LoginController {	
	ProgramInformation ProgramInformation = new ProgramInformation();
	Database_Controller DatabaseController = new Database_Controller();
	
	@FXML
	public TextField Username; 
	
	@FXML
	private PasswordField Password;
	
	@FXML
	private Label ErrorLabel;
	
	@FXML
	private Button NextButton;
	
	@FXML
	private Button BackButton;
	
	@FXML
	private Button RegistrationLink;
	
	@FXML
	private void BackToWelcome(ActionEvent event) throws IOException {
		new SceneBuilder().SetScene(event, true, "Welcome.fxml", "Welcome", null);
	}
	
	@FXML
	private void SendToMain(ActionEvent event) throws IOException, SQLException {
		//Reseting the Error Label
		ResetErrorLabel();
					
		//Check for any errors
		if (CheckingIfAllFieldsFilled() == false) {
			ErrorLabel.setText("Please fill in all the fields.");
			ErrorLabel.setVisible(true);
		}
		else {
			CheckCredentials();
		}
		//new SceneBuilder().SetScene(event , true, "Main.fxml", "Main", null);
	}
	
	private void CheckCredentials() throws SQLException {
		String UsersPassword = DatabaseController.CheckValuesInDatabase("Password", "UserInformation", "Username='" + Username.getText() + "'");
		if (CheckIfUsernameIsValid() == true) {
			if(Password.getText().equals(UsersPassword)) {
				System.out.println("Sent to main page");
			}
			else {
				ErrorLabel.setText("Password is incorrect. Please try again.");
				ErrorLabel.setVisible(true);
			}
		}
		else {
			ErrorLabel.setText("Username does not exist. Please try again.");
			ErrorLabel.setVisible(true);
		}
	}
	
	private boolean CheckIfUsernameIsValid() throws SQLException {
		String UsernameFromDatabase = DatabaseController.CheckValuesInDatabase("Username", "UserInformation", "Username='" + Username.getText() + "'");
		if(UsernameFromDatabase == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private void ResetErrorLabel() {
		ErrorLabel.setVisible(false);
		ErrorLabel.setText("");
	}
	
	private boolean CheckingIfAllFieldsFilled() {
		if (Username.getText().isEmpty() || Password.getText().isEmpty()) {
			return false;
		}	
		else {
			return true; 
		}
	}
	
    @FXML
    private void ToRegistrationPage(ActionEvent event) throws IOException{
    	new SceneBuilder().SetScene(event, true, "RegistrationNoBackButton.fxml", "Registration", null);
    }
}

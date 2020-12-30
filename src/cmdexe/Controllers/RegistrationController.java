package cmdexe.Controllers;

import java.io.IOException;
import cmdexe.Welcome;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class RegistrationController {
	
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
	private void BackToWelcome(ActionEvent event) throws IOException {
		new Welcome().WelcomePage(event);
    }
	
	@FXML
	private void ToMain(ActionEvent event) {
		//Reseting the Error Label
		ResetErrorLabel();
		
		//Checking if all the fields are filled
		CheckingIfAllFieldsFilled();
		
		//Checking if the password is more than 8 charaters. 
		PasswordCorrectLength();
		
		//Check for any errors
		if (AllFieldsFilled == false) {
			ErrorLabel.setText("Please fill in all the fields.");
		}
		else if (PasswordCorrectLength == false) {
			ErrorLabel.setText("Your password isn't strong enough. Please make a stronger password.");
		}
		else {
			//Put the data into the database
			PutInfoIntoDatabase();
			
			//Send the user to the main page
			MoveToMainScreen();
		}
	}
	
	private boolean AllFieldsFilled;
	private boolean PasswordCorrectLength;
	
	private void ResetErrorLabel() {
		ErrorLabel.setVisible(false);
		ErrorLabel.setText("");
	}
	
	private void CheckingIfAllFieldsFilled() {
		if (Username.getText().isEmpty() || Password.getText().isEmpty() || HostIP.getText().isEmpty() || HostUsername.getText().isEmpty() || HostPassword.getText().isEmpty()) {
				AllFieldsFilled = true;
		}	
		else {
			AllFieldsFilled = false; 
		}
	}
	
	private void PasswordCorrectLength() {
		if (Password.getText().length() < 8) {
			ErrorLabel.setText("Your password isn't strong enough. Please make a stronger password");
		}
		else {
			PasswordCorrectLength = false;
		}
	}
	
	private void PutInfoIntoDatabase() {
		
	}
	
	private void MoveToMainScreen() {
		
	}
}

package cmdexe.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import cmdexe.ProgramInformation;

public class LoginController {	
	ProgramInformation ProgramInformation = new ProgramInformation();
	
	@FXML
	public TextField Username; 
	
	@FXML
	private PasswordField Password;
	
	@FXML
	private Button NextButton;
	
	@FXML
	private Button BackButton;
	
	@FXML
	private void BackToWelcome() {
		
	}
	
	@FXML
	private void ToMain() {
		
	}
	
	private void CheckCredentials() {
		
	}
}

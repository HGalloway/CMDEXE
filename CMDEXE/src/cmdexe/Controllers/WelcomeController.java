package cmdexe.Controllers;

import java.io.IOException;
import cmdexe.Methods;
import cmdexe.Methods.FilesAndFolders;
import cmdexe.Login;
import cmdexe.Registration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WelcomeController {
	Methods Methods = new Methods();
	FilesAndFolders FilesAndFolders = Methods.new FilesAndFolders();
	
    //Registration Button
    @FXML
    private void ToRegistrationPage(ActionEvent event) throws IOException{
    	WriteWelcomeBooleanToFile();
    	new Registration().RegistrationPage(event);
    }
    
    //Login Button
    @FXML
    private void ToLoginPage(ActionEvent event) throws IOException{
    	WriteWelcomeBooleanToFile();
    	new Login().LoginPage(event);
    }
    
	private void WriteWelcomeBooleanToFile() throws IOException {
    	FilesAndFolders.ReadInFile("C:\\Users\\hdg11\\eclipse-workspace\\CMDEXE\\src\\cmdexe", "UserInformation.UI");
    	FilesAndFolders.WriteToFile("C:\\Users\\hdg11\\eclipse-workspace\\CMDEXE\\src\\cmdexe", "C:\\Users\\hdg11\\eclipse-workspace\\CMDEXE\\src\\cmdexe", "SeenWelcomePage=True");
    }
}
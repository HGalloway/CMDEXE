package cmdexe.Controllers;

import java.io.IOException;
import cmdexe.Methods;
import cmdexe.Methods.FilesAndFolders;
import cmdexe.SceneBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class WelcomeController {
	Methods Methods = new Methods();
	FilesAndFolders FilesAndFolders = Methods.new FilesAndFolders();
	
    //Registration Button
    @FXML
    private void ToRegistrationPage(ActionEvent event) throws IOException{
    	//WriteWelcomeBooleanToFile();
    	new SceneBuilder().SetScene(event, true, "Registration.fxml", "Registration", null);
    }
    
    //Login Button
    @FXML
    private void ToLoginPage(ActionEvent event) throws IOException{
    	WriteWelcomeBooleanToFile();
    	new SceneBuilder().SetScene(event, true, "Login.fxml", "Login", null);
    }
    
	private void WriteWelcomeBooleanToFile() throws IOException {
		Methods Methods = new Methods();
		FilesAndFolders FilesAndFolders = Methods.new FilesAndFolders();
		
		FilesAndFolders.ReadInFile(System.getProperty("user.dir") + "\\CMDEXE\\cmdexe\\cmdexe", "SystemInformation.dir"); 
		
		if(FilesAndFolders.LineText.size() == 2) {
			FilesAndFolders.WriteToFile(System.getProperty("user.dir") + "\\CMDEXE\\cmdexe\\cmdexe", "SystemInformation.dir", "\nSeenWelcomePage=\"true\"");
		}
    }
}

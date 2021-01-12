package cmdexe;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class CMDEXE extends Application{
	public Stage primaryStage = new Stage();
	public ActionEvent event = new ActionEvent();
	@Override
    public void start(Stage prime) throws IOException {
		ProgramInformation ProgramInformation = new ProgramInformation();
		ProgramInformation.GetSystemInformation(); //Setting Path Information
		
		if (ProgramInformation.SeenWelcomePage == true) {
			new SceneBuilder().SetScene(event, false, "LoginNoBackButton.fxml", "Login", null);
		}
		else {
			//Starting Welcome Page
			new SceneBuilder().SetScene(event, false, "Welcome.fxml", "Welcome", null);
		}
		
    	//Exiting Application
        primaryStage.setOnCloseRequest(e->{
        	Platform.exit();
    		System.exit(0);
        });
    }
	public static void main(String[] args) {
		launch(args);
    }	
}
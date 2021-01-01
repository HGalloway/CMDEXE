package cmdexe;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class CMDEXE extends Application{
	public Stage primaryStage = new Stage();
	@Override
    public void start(Stage prime) throws IOException {
		ProgramInformation ProgramInformation = new ProgramInformation();
		ProgramInformation.GetInformation(); //Setting Path Information
		
		System.out.println(ProgramInformation.SeenWelcomePage);
		
		ActionEvent event = new ActionEvent();
		
		if (ProgramInformation.SeenWelcomePage == true) {
			//Starting Login Page
			//new Login().LoginPage(event);
		}
		else {
			//Starting Welcome Page
			new Welcome().WelcomePageStart(event);
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
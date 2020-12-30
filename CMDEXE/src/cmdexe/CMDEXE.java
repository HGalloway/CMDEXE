package cmdexe;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class CMDEXE extends Application{
	public static void main(String[] args){
		System.out.println("Yeet");
        //launch(args);
    }
	public Stage primaryStage = new Stage();
	@Override
    public void start(Stage prime) throws IOException {
		//Starting application
		ActionEvent event = new ActionEvent();
		new Welcome().WelcomePage(event);
		
    	//Exiting Application
        primaryStage.setOnCloseRequest(e->{
        	Platform.exit();
    		System.exit(0);
        });
    }

}
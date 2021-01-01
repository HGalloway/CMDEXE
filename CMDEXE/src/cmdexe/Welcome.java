package cmdexe;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Welcome {
	CMDEXE cmdexe = new CMDEXE();
    public void WelcomePageStart(ActionEvent event) throws IOException {
    	Scene WelcomeScene = new Scene(FXMLLoader.load(getClass().getResource("Style\\Welcome.fxml")));
    	cmdexe.primaryStage.setScene(WelcomeScene);
    	cmdexe.primaryStage.setTitle("Welcome");
    	cmdexe.primaryStage.show();
    }   
    public void WelcomePage(ActionEvent event) throws IOException {
    	Scene WelcomeScene = new Scene(FXMLLoader.load(getClass().getResource("Style\\Welcome.fxml")));
    	cmdexe.primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
    	cmdexe.primaryStage.setScene(WelcomeScene);
    	cmdexe.primaryStage.setTitle("Welcome");
    	cmdexe.primaryStage.show();
    }
}

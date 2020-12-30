package cmdexe;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class Welcome {
    public void WelcomePage(ActionEvent event) throws IOException {
    	CMDEXE cmdexe = new CMDEXE();
    	Scene WelcomeScene = new Scene(FXMLLoader.load(getClass().getResource("Style\\Welcome.fxml")));
    	cmdexe.primaryStage.setScene(WelcomeScene);
    	cmdexe.primaryStage.setTitle("Welcome");
    	cmdexe.primaryStage.show();
    }   
}

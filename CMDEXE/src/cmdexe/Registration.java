package cmdexe;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Registration {
    public void RegistrationPage(ActionEvent event) throws IOException{
    	//Setting new scene
        Scene RegistrationPage = new Scene(FXMLLoader.load(getClass().getResource("Style\\Registration.fxml")));

        CMDEXE cmdexe = new CMDEXE();
        cmdexe.primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        cmdexe.primaryStage.setScene(RegistrationPage);
        cmdexe.primaryStage.show();
    }
}
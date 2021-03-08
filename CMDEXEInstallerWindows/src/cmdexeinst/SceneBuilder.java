package cmdexeinst;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneBuilder {
	public void SetScene(ActionEvent event, boolean GetWindow, String FileName, String WindowTitle, String ICOName)
			throws IOException {
		// Setting new scene
		Scene NewScene = new Scene(FXMLLoader.load(getClass().getResource("\\src\\cmdexeinst\\" + "FileName")), 800, 650);
		
		CMDEXEInstaller CMDEXEInstaller = new CMDEXEInstaller();
		if (GetWindow == true) {
			CMDEXEInstaller.primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		}
		CMDEXEInstaller.primaryStage.setScene(NewScene);
		CMDEXEInstaller.primaryStage.setTitle(WindowTitle);
		// cmdexe.primaryStage.getIcons().add(new Image("Style\\ICO" + ICOName));
		CMDEXEInstaller.primaryStage.show();
	}
}

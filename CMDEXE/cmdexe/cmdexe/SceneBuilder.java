package cmdexe;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneBuilder {
	public void SetScene(ActionEvent event, boolean GetWindow, String FileName, String WindowTitle, String ICOName) throws IOException {
		// Setting new scene
		Scene NewScene = new Scene(FXMLLoader.load(CMDEXE.class.getResource("Style\\FXML\\" + FileName)), 800, 650);

		CMDEXE cmdexe = new CMDEXE();
		if (GetWindow == true) {
			cmdexe.primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		}
		cmdexe.primaryStage.setScene(NewScene);
		cmdexe.primaryStage.setTitle(WindowTitle);
		//cmdexe.primaryStage.getIcons().add(new Image("Style\\ICO" + ICOName));
		cmdexe.primaryStage.show();
	}
}

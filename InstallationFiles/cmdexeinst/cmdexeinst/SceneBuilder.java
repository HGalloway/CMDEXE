package cmdexeinst;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SceneBuilder {

	@FXML
	private Label ErrorLabel;

	public void SetScene(ActionEvent event, boolean GetWindow, String FileName, String WindowTitle, String ICOName) throws IOException {
		Scene NewScene = new Scene(FXMLLoader.load(CMDEXEInstaller.class.getResource("Style\\FXML\\" + FileName)), 800, 650);
		
		CMDEXEInstaller CMDEXEInstaller = new CMDEXEInstaller();
		if (GetWindow == true) {
			CMDEXEInstaller.primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		}
		CMDEXEInstaller.primaryStage.setScene(NewScene);
		CMDEXEInstaller.primaryStage.setTitle(WindowTitle);
		//CMDEXEInstaller.primaryStage.getIcons().add(new Image("Style\\ICO" + ICOName));
		CMDEXEInstaller.primaryStage.show();
	}
	public void SetErrorPopup(String ErrorText) throws IOException {
		Stage PopupStage = new Stage();

		Scene NewScene = new Scene(FXMLLoader.load(CMDEXEInstaller.class.getResource("Style\\FXML\\ErrorPopup.fxml")), 400, 325);
		PopupStage.setScene(NewScene);
		PopupStage.setTitle("Error");
		//PopupStage.getIcons().add(new Image("Style\\ICO\\Error.ico"));
		PopupStage.show();
		ErrorLabel.setText("");

		PopupStage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
	}
}

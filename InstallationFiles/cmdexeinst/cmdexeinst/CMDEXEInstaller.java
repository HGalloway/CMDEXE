package cmdexeinst;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import cmdexeinst.Methods.OS;

public class CMDEXEInstaller extends Application{
	public Stage primaryStage = new Stage();
	public ActionEvent event = new ActionEvent();
	@Override
	public void start(Stage prime) throws IOException {
		Methods Methods = new Methods();
		OS OS = Methods.new OS();
		OS.GetOperatingSystem();

		new SceneBuilder().SetScene(event, false, "WelcomeInstaller.fxml", "Welcome", null);

		primaryStage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
	} 

	public static void main(String[] args) {
		launch(args);
	}
}

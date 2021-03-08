package cmdexeinst;

import java.io.IOException;

import cmdexeinst.SceneBuilder;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class CMDEXEInstaller extends Application{
	public Stage primaryStage = new Stage();
	public ActionEvent event = new ActionEvent();
	@Override
	public void start(Stage prime) throws IOException {
		new SceneBuilder().SetScene(event, false, "Welcome.fxml", "Welcome", null);
		// Exiting Application
		primaryStage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
	} 

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir") + "\\src\\cmdexeinst\\Yeet.txt");
		launch(args);
	}

}

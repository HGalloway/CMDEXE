package cmdexeinst.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import cmdexeinst.SceneBuilder;

public class WelcomeController {
    SceneBuilder SceneBuilder = new SceneBuilder();

    @FXML
    private void ToInstallPathPage(ActionEvent event) throws IOException {
        SceneBuilder.SetScene(event, true, "InstallPath.fxml", "Configure Path", "");
    }
}

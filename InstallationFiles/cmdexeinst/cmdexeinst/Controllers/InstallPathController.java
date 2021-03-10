package cmdexeinst.Controllers;

import java.io.File;
import java.io.IOException;
import cmdexeinst.SceneBuilder;
import cmdexeinst.CMDEXEInstaller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

public class InstallPathController {
    SceneBuilder SceneBuilder = new SceneBuilder();
    CMDEXEInstaller CMDEXEInstaller = new CMDEXEInstaller();

    @FXML
    private VBox CenterVBox;

    @FXML
    private void InstallPage(ActionEvent event) throws IOException {
        SceneBuilder.SetScene(event, true, "Install.fxml", "Installing CMDEXE", "");
    }

    private void InitDirectoryChooser(){
        DirectoryChooser DirectoryChooser = new DirectoryChooser();

        File SelectedDirectory = DirectoryChooser.showDialog(CMDEXEInstaller.primaryStage);
        File InitDirectory = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Downloads");
        DirectoryChooser.setInitialDirectory(InitDirectory);
        System.out.println(SelectedDirectory);
    }
}

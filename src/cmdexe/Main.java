package cmdexe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main {
    public void MainPage(Stage Stages){
        //New StackPane
        StackPane MainPane = new StackPane();
        //Main page
        
        //Setting scene
        Scene Main = new Scene(MainPane, 300, 250);
        Stages.setScene(Main);

        
        //Updates button
        Button Updates = new Button();
        Updates.setText("Updates");
        Updates.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                Updates Update = new Updates();
                Update.UpdatePage(Stages);
            }
            
        });
        
        //Adding everything to StackPane
        MainPane.getChildren().add(Updates);
    }
    
}

package cmdexe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Updates{
    public void UpdatePage(Stage Stages){
        //New StackPane 
        StackPane UpdatePane = new StackPane();

        //Setting scene
        Scene Updates = new Scene(UpdatePane, 300, 250);
        Stages.setScene(Updates);

        //Update Repositories button
        Button UpdateRepo = new Button();
        UpdateRepo.setText("Update Repositories");
        UpdateRepo.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event){
                    
                }
            });
            //Adding everything to StackPane
            UpdatePane.getChildren().add(UpdateRepo);
    }
}

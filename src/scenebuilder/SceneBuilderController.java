package scenebuilder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class SceneBuilderController implements Initializable {

    @FXML
    private Button clickMeButton;

    @FXML
    private Label labelId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                labelId.setText("Hey there");
            }
        });
    }
}

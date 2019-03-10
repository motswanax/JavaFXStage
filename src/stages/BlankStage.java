package stages;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * @author baike
 */
public class BlankStage extends Application {
    private Label myLabel;
    private TextField nameTextField;

    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX Stage"); // optional

        Button button = new Button();
        button.setText("Click me");

        myLabel = new Label();
        myLabel.setText("This is a label");

        nameTextField = new TextField();
        nameTextField.setPromptText("Enter your name");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = nameTextField.getText().trim();
                if (!name.equals("") && !name.equals(null)) {
                    myLabel.setText(name);
                } else {
                    myLabel.setText("You didn't type anything.");
                }


                System.out.println("Hello JavaFX");
            }
        });

        FlowPane flowPaneRoot = new FlowPane(10, 10);
        flowPaneRoot.setAlignment(Pos.CENTER);

//        StackPane root = new StackPane();
        flowPaneRoot.getChildren().add(button);
        flowPaneRoot.getChildren().add(myLabel);
        flowPaneRoot.getChildren().add(nameTextField);
        Scene scene = new Scene(flowPaneRoot, 250, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

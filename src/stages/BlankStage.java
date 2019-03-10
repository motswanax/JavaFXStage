package stages;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author baike
 */
public class BlankStage extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX Stage"); // optional

        Button button = new Button();
        button.setText("Click me");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello JavaFX");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);
        Scene scene = new Scene(root, 250, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

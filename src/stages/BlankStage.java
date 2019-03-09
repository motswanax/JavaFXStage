package stages;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author baike
 */
public class BlankStage extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX Stage"); // optional

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

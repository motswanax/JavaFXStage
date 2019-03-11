package scenebuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author baike
 */
public class SceneBuilderDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scenebuilder.fxml"));
        stage.setTitle("Hello Scene Builder");
        stage.setScene(new Scene(root, 700, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

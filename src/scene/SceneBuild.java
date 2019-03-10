package scene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneBuild extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Stage with scene");

        VBox root = new VBox();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(350, 50);
        root.getChildren().add(canvas);
        stage.setScene(scene);

        Text msg = new Text("Hello World");
        root.getChildren().add(msg);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

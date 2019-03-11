package lifecycle;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * @author baike
 */
public class LifeCycle extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Start begins");
        stage.setTitle("Life Cycle");

        FlowPane root = new FlowPane(Orientation.VERTICAL, 5, 5);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 700, 400);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Init begins");
    }

    @Override
    public void stop() throws Exception {
        super.stop();

        System.out.println("Stop invoked");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

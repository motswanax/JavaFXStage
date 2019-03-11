package effects;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 * @author baike
 */
public class EffectsTransformations extends Application implements EventHandler {

    private Button rotateButton;
    private Button blurButton;
    private Button scaleButton;
    private Button reflectButton;

    private Rotate rotate;
    private double angle;
    private double blurVal;

    private BoxBlur blur;

    private double scaleFactor;
    private Scale scale;

    private Reflection reflection;
    private Label reflect;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Life Cycle");

        angle = 0.0;
        blurVal = 1.0;
        scaleFactor = 0.4;

        rotateButton = new Button("Rotate");
        blurButton = new Button("Blur");
        scaleButton = new Button("Scale");
        reflectButton = new Button("Reflect");
        reflection = new Reflection();

        rotate = new Rotate();
        blur = new BoxBlur(1.0, 1.0, 1);
        scale = new Scale(scaleFactor, scaleFactor);

        // Register the buttons
        rotateButton.setOnAction(this);
        blurButton.setOnAction(this);
        scaleButton.setOnAction(this);
        reflectButton.setOnAction(this);

        reflect = new Label("Reflection adds visual sparkle");

        FlowPane root = new FlowPane(5, 5);
        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(rotateButton, blurButton, scaleButton, reflectButton, reflect);

        Scene scene = new Scene(root, 350, 120);
        stage.setScene(scene);

        stage.show();

        // setup transformations
        rotateButton.getTransforms().add(rotate);
        scaleButton.getTransforms().add(scale);
        /*reflection.setTopOpacity(0.7);
        reflection.setBottomOpacity(0.3);

        // Use the label and apply reflection effect
        reflect.setEffect(reflection);*/
    }

    @Override
    public void handle(Event event) {
        if (event.getSource().equals(rotateButton)) {
            angle += 15.0;
            rotate.setAngle(angle);
            rotate.setPivotX(rotateButton.getWidth()/2);
            rotate.setPivotY(rotateButton.getHeight()/2);
        }

        if (event.getSource().equals(blurButton)) {
            // each time button is pressed, change its blur
            if (blurVal == 10.0) {
                blurVal = 1.0;
                blurButton.setEffect(null);
                blurButton.setText("Blur off");
            } else {
                blurVal++;
                blurButton.setEffect(blur);
                blurButton.setText("Blur on");
            }

            blur.setWidth(blurVal);
            blur.setHeight(blurVal);
        }

        if (event.getSource().equals(scaleButton)) {
            scaleFactor += 0.1;
            if (scaleFactor > 2.0) scaleFactor = 0.4; // reset it

            scale.setX(scaleFactor);
            scale.setY(scaleFactor);
        }

        if (event.getSource().equals(reflectButton)) {
            if (reflectButton.getText().equalsIgnoreCase("Reflect")) {
                reflection.setTopOpacity(0.7);
                reflection.setBottomOpacity(0.3);

                // Use the label and apply reflection effect
                reflect.setEffect(reflection);
                reflectButton.setText("Turn off");
            } else {
                reflect.setEffect(null);
                reflectButton.setText("Reflect");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

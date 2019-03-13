package loginscreencontroller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author baike
 */
public class LoginScreenController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField loginUsername;

    @FXML
    private JFXPasswordField loginPassword;

    @FXML
    private JFXButton loginButton;

    @FXML
    void initialize() {

        loginUsername.setStyle("-fx-text-fill: #a0a2ab");
        loginPassword.setStyle("-fx-text-fill: #a0a2ab");

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loginUser();
            }
        });

    }

    private void loginUser() {

        // Get the main window
        loginButton.getScene().getWindow().hide();

        if (!loginUsername.getText().trim().equals("") && !loginPassword.getText().trim().equals("")) {
            // create new stage
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/loginscreenview/details.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Details");
            stage.setScene(new Scene(root));

            // Get the controller
            DetailsController detailsController = loader.getController();
            detailsController.setDetailsName(loginUsername.getText(), "Java Developer", 31);

            stage.show();
        }
    }
}

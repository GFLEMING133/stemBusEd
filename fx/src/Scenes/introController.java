package Scenes;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextField.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class introController {
    @FXML TextField userBox;
    @FXML Button enterButton;
    @FXML GridPane largeGrid;
    @FXML AnchorPane pane;

    private MediaTests mt = new MediaTests();

    public void initialize(MediaTests mediatest, Scene scene) {
        System.out.println("Started the controller");
        mt = mediatest;
        largeGrid.minHeightProperty().bind(scene.heightProperty());
        largeGrid.minWidthProperty().bind(scene.widthProperty());
    }

    public void saveUserInfo(ActionEvent actionEvent) {
        MediaTests.user = userBox.getText();
        System.out.println(MediaTests.user);
        mt.moveToObjectiveScene();
    }
}

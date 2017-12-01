package Scenes;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextField.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class introController {
    @FXML TextField userBox;
    @FXML Button enterButton;
    private MediaTests mt = new MediaTests();

    public void initialize(MediaTests mediatest) {
        System.out.println("Started the controller");
        mt = mediatest;
        // Work here.
    }

    public void saveUserInfo(ActionEvent actionEvent) {
        MediaTests.user = userBox.getText();
        System.out.println(MediaTests.user);
        mt.moveToObjectiveScene();
    }
}

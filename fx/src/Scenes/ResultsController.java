package Scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class ResultsController {
    private MediaTests mt = new MediaTests();
    @FXML Text text;
    @FXML GridPane largeGrid;

    public void initialize(MediaTests mediatest, Scene scene) {
        mt = mediatest; //assign the reference of mediatest to mt
        System.out.println("Started the results controller");
        largeGrid.minHeightProperty().bind(scene.heightProperty());
        largeGrid.minWidthProperty().bind(scene.widthProperty());

        text.setText("You answered "+mt.numCorrect+" questions correctly.\nYour score is: "+(mt.numCorrect*100.0/mt.questions)+"%");
    }

    public void callToRepeat() {
        mt.repeatProcess();
    }
}

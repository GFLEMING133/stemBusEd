package Scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ResultsController {
    private MediaTests mt = new MediaTests();
    @FXML Text text;

    public void initialize(MediaTests mediatest) {
        mt = mediatest; //assign the reference of mediatest to mt
        System.out.println("Started the results controller");

        text.setText("You answered "+mt.numCorrect+" questions correctly.\nYour score is: "+(mt.numCorrect*100.0/mt.totalQuestions)+"%");
    }
}

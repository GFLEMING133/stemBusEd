package Scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class End {
    private MediaTests mt = new MediaTests();
    @FXML Text text;

    public void initialize(MediaTests mediatest) {
        mt = mediatest; //assign the reference of mediatest to mt
        System.out.println("Started the results controller");

        text.setText("You answered "+mt.numCorrectTotal+" questions correctly.\nYour score is: "+(mt.numCorrectTotal*100.0/mt.totalQuestions)+"%");
    }
}

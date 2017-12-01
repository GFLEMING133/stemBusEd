package Scenes;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

public class ObjectiveController {
    private MediaTests mt = new MediaTests();
    @FXML Button videoButton;

    public void initialize(MediaTests mediatest) {
        mt = mediatest; //assign the reference of mediatest to mt
        System.out.println("Started the objective controller");
    }

    public void callToVideo(ActionEvent actionEvent) {
        System.out.println("No problems with pressing button...");
        mt.moveToVideoScene();
    }

    public void callToQuiz(ActionEvent actionEvent) {
//        System.out.println("No problems with pressing button...");
//        mt.moveToQuizScene();
    }

    public void callToIntro(ActionEvent actionEvent) {
//        System.out.println("No problems with pressing button...");
//        mt.moveToIntroScene();
    }

    public void callToResults(ActionEvent actionEvent) {
//        System.out.println("No problems with pressing button...");
//        mt.moveToResultsScene();
    }
}

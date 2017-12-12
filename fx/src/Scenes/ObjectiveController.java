package Scenes;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ObjectiveController {
    private MediaTests mt = new MediaTests();
    @FXML Button videoButton = new Button();
    @FXML ImageView bmImage;
    @FXML GridPane largeGrid;

    public void initialize(MediaTests mediatest, Scene scene) {
        mt = mediatest; //assign the reference of mediatest to mt
        largeGrid.minHeightProperty().bind(scene.heightProperty());
        largeGrid.minWidthProperty().bind(scene.widthProperty());
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

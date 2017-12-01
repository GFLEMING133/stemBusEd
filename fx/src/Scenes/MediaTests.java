package Scenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MediaTests extends Application {
    private Stage primaryStage;
    private AnchorPane rootLayout;
    private AnchorPane objectiveRoot;
    private AnchorPane movieRoot;
    private AnchorPane quizRoot;
    private AnchorPane resultsRoot;

    public void start(Stage primaryStage2)
    {
        primaryStage = primaryStage2;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("IntroScene.fxml"));
            rootLayout = loader.load();
            introController controller = loader.getController();
            controller.initialize(this);
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        Scene IntroScene = new Scene(rootLayout);
        primaryStage.setScene(IntroScene);
        primaryStage.show();
    }

    public void moveToObjectiveScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ObjectiveScene.fxml"));
            objectiveRoot = loader.load();
            ObjectiveController controller = loader.getController();
            controller.initialize(this);
            // ^_^ remember that we have to pass in the mediatests object.
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        Scene ObjectiveScene = new Scene(objectiveRoot);
        primaryStage.setScene(ObjectiveScene);
        primaryStage.show();
    }

    public void moveToVideoScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("VideoScene.fxml"));
            movieRoot = loader.load();
            VideoController controller = loader.getController();
            controller.initialize(this);
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        Scene videoScene = new Scene(movieRoot);
        primaryStage.setScene(videoScene);
        primaryStage.show();
    }

    public void moveToQuizScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("QuizScene.fxml"));
            quizRoot = loader.load();
            QuizController controller = loader.getController();
            controller.initialize(this);
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        Scene quizScene = new Scene(quizRoot);
        primaryStage.setScene(quizScene);
        primaryStage.show();
    }

    public void moveToIntroScene() {
        start(primaryStage);
    }

    public void moveToResultsScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ResultsScene.fxml"));
            resultsRoot = loader.load();
            ResultsController controller = loader.getController();
            controller.initialize(this);
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        Scene resultsScene = new Scene(resultsRoot);
        primaryStage.setScene(resultsScene);
        primaryStage.show();
    }

    public static String user ="";
    public static String quizPath = "mcTest.txt";
    public static int numCorrect = 0;
    public static int totalQuestions = 0;
    public static void main(String [] args) {
        launch(args);
    }
}
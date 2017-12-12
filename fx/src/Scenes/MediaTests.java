package Scenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

public class MediaTests extends Application {
    private Stage primaryStage;
    private AnchorPane rootLayout;
    private AnchorPane objectiveRoot;
    private AnchorPane movieRoot;
    private AnchorPane quizRoot;
    private AnchorPane resultsRoot;
    private AnchorPane endRoot;

    private String videoPath = "";
    private String quizPath = "";
    private String imagePath = "";

    private Scanner fileIn;
    private String pathForFiles = "fileDocument.txt";

    public void start(Stage primaryStage2)
    {
        try {
            fileIn = new Scanner(new File(pathForFiles));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        getNewFileNames();

        primaryStage = primaryStage2;
        introController controller = new introController();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("IntroScene.fxml"));
            rootLayout = loader.load();
            controller = loader.getController();
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        Scene IntroScene = new Scene(rootLayout);
        controller.initialize(this, IntroScene);
        primaryStage.setScene(IntroScene);
        primaryStage.show();
    }

    public void moveToObjectiveScene() {
        ObjectiveController controller = new ObjectiveController();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ObjectiveScene.fxml"));
            objectiveRoot = loader.load();
            controller = loader.getController();
            // ^_^ remember that we have to pass in the mediatests object.
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        Scene ObjectiveScene = new Scene(objectiveRoot);
        controller.initialize(this, ObjectiveScene);
        primaryStage.setScene(ObjectiveScene);
        primaryStage.show();
    }

    public void moveToVideoScene() {
        VideoController controller = new VideoController();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("VideoScene.fxml"));
            movieRoot = loader.load();
            controller = loader.getController();
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        Scene videoScene = new Scene(movieRoot);
        controller.initialize(this, videoPath, imagePath, videoScene);
        primaryStage.setScene(videoScene);
        primaryStage.show();
    }

    public void moveToQuizScene() {
        QuizController controller = new QuizController();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("QuizScene.fxml"));
            quizRoot = loader.load();
            controller = loader.getController();
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        Scene quizScene = new Scene(quizRoot);
        controller.initialize(this, quizPath, quizScene);
        primaryStage.setScene(quizScene);
        primaryStage.show();
    }

    public void moveToResultsScene() {
        ResultsController controller = new ResultsController();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ResultsScene.fxml"));
            resultsRoot = loader.load();
            controller = loader.getController();
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        Scene resultsScene = new Scene(resultsRoot);
        controller.initialize(this, resultsScene);
        primaryStage.setScene(resultsScene);
        primaryStage.show();
    }

    public boolean getNewFileNames() {
        if(fileIn.hasNext()) {
            String str[] = fileIn.nextLine().split("\t");
            if (str[0].equals("V")) {
                videoPath = str[1];
            }

            str = fileIn.nextLine().split("\t");
            if (str[0].equals("I")) {
                imagePath = str[1];
            }

            str = fileIn.nextLine().split("\t");
            if (str[0].equals("Q")) {
                quizPath = str[1];
            }

            return true;
        }
        else {
            return false;
        }
    }

    public void moveToEndScene() {
        End controller = new End();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("End.fxml"));
            endRoot = loader.load();
            controller = loader.getController();
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        Scene endScene = new Scene(endRoot);
        controller.initialize(this, endScene);
        primaryStage.setScene(endScene);
        primaryStage.show();
    }

    public void repeatProcess() {
        boolean run = getNewFileNames();

        if(run) {
            moveToVideoScene();
        }
        else {
            moveToEndScene();
        }
    }

    public static String user ="";
    public static int numCorrect = 0;
    public static int questions = 0;
    public static int numCorrectTotal = 0;
    public static int totalQuestions = 0;
    public static void main(String [] args) {
        launch(args);
    }
}
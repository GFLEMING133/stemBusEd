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
            controller.initialize(this, videoPath, imagePath);
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
            controller.initialize(this, quizPath);
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
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("End.fxml"));
            endRoot = loader.load();
            End controller = loader.getController();
            controller.initialize(this);
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        Scene quizScene = new Scene(endRoot);
        primaryStage.setScene(quizScene);
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
package OldScenes;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SceneDriver extends Application
{
    static BufferedWriter bw;
    static String fileWriteName = "C:\\Users\\janecekem\\Desktop\\names.txt";
    static boolean completedSignIn = false;
    static boolean completedMovie = false;
    static boolean completedQuiz = false;
    static SignIn in;
    static VideoPlayer video;
    static Quiz quiz;
    static String movieFile = "C:\\Users\\janecekem\\IdeaProjects\\FXProjects\\src\\Tests\\lessEmbarrassingVideo.mp4";
    static String quizFile = "C:\\Users\\janecekem\\Desktop\\mcTest.txt";
    static Stage mainStage;
    static End end;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        mainStage = primaryStage;
        signIn();
    }

    public static void signIn()
    {
        in = new SignIn(mainStage);
        in.run(mainStage);
    }

    public static void movie()
    {
        video = new VideoPlayer();
        video.run(mainStage, movieFile);
    }

    public static void quiz()
    {
        quiz = new Quiz();
        quiz.run(mainStage, quizFile);
    }

    public static void nextScene()
    {
        if(!completedSignIn)
        {
            String name = in.getName();

            try
            {
                File f = new File(fileWriteName);
                f.createNewFile();

                bw = new BufferedWriter(new FileWriter(fileWriteName));
                bw.write(name);
                bw.newLine();
            }
            catch (Exception e)
            {
                System.out.println(e);
                System.out.println("Don't care");
            }
            completedSignIn = true;
            movie();
        }
        else if(!completedMovie)
        {
            completedMovie = true;
            quiz();
        }
        else if(!completedQuiz)
        {
            completedQuiz = true;
            double percent = quiz.getPercent();
            try {
                bw.write("Score: " + percent + "%");
                bw.newLine();
                bw.close();
            }
            catch (Exception e) {
                System.out.println("Don't care");
            }
            end = new End();
            end.run(mainStage, percent);
        }
        else
        {

        }
    }
}
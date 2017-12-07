package OldScenes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class MediaJumble extends Application
{
    final int numQuestions = 4;
    boolean newQuestion = true;
    int questionNum = 0;
    int correctQuestions = 0;
    String currentDumpSpot = "C:\\Users\\flemingg\\IdeaProjects\\blueMangoesTest2";

    public static void main(String[] args)
    {
        launch(args);
    }
    boolean playing = false;
    BufferedWriter bw;
    MediaPlayer player = new MediaPlayer(new Media(Paths.get(currentDumpSpot + "\\lessEmbarrassingVideo.mp4").toUri().toString()));
    String name = "Ethan";
    Button playButton = new Button("Play the video!");
    Button btn = new Button("Go to quiz!");


    @Override
    public void start(Stage primaryStage)
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 1024, 768);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Welcome!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Enter Your Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Button login = new Button("Sign in");
        HBox hbLogin = new HBox(10);
        hbLogin.setAlignment(Pos.BOTTOM_RIGHT);
        hbLogin.getChildren().add(login);
        grid.add(hbLogin, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 6);

        primaryStage.setScene(scene);
        primaryStage.show();

        login.setOnAction((event)->{
            name = userTextField.getText();
            System.out.println(name);
            try
            {
                File f = new File(currentDumpSpot + "\\names.txt");
                f.createNewFile();

                bw = new BufferedWriter(new FileWriter(currentDumpSpot + "\\names.txt"));

                bw.write(name);
                bw.newLine();
            }
            catch (Exception e)
            {
                System.out.println(e);
                System.out.println("Don't care");
            }

            Scene scene1 = new Scene(playVideo(grid), 1024, 768);
            primaryStage.setScene(scene1);
        });

        playButton.setOnAction((event) -> {
            if (getPlaying()) {
                player.pause();
                setPlaying(false);
            } else if (!getPlaying()) {
                player.play();
                setPlaying(true);
            }
        });
        btn.setOnAction((event) -> {
            grid.getChildren().clear();
            Text scenetitle2 = new Text("");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            grid.add(scenetitle2, 0, 0, 2, 5);

            Scanner in = new Scanner(System.in);
            try {
                in = new Scanner(new File(currentDumpSpot + "\\mcTest.txt"));
            }
            catch (Exception e)
            {
                System.out.println(e);
            }

            setNewQuestion(in, primaryStage);
        });


    }

    public GridPane playVideo(GridPane grid)
    {
        MediaView mediaView = new MediaView(player);
        GridPane vidGrid = new GridPane();
        vidGrid.getChildren().clear();
        vidGrid.setPadding(new Insets(25, 25, 25, 25));
        vidGrid.add(mediaView, 0,0);
        vidGrid.add(playButton, 1,1);
        vidGrid.add(btn, 1,0);
       return vidGrid;
    }

    public void setNewQuestion(Scanner in, Stage primaryStage)
    {
        GridPane questionGrid = new GridPane();
        if(newQuestion) {
            newQuestion = false;
            String question = "";
            String ansA = "";
            String ansB = "";
            String ansC = "";
            String ansD = "";

            String correctionA1 = "";
            String correctionB1 = "";
            String correctionC1 = "";
            String correctionD1 = "";

            try {
                question = in.nextLine();
                String A[] = in.nextLine().split("\t");
                String B[] = in.nextLine().split("\t");;
                String C[] = in.nextLine().split("\t");;
                String D[] = in.nextLine().split("\t");;

                ansA = A[0];
                correctionA1 = A[1];
                ansB = B[0];
                correctionB1 = B[1];
                ansC = C[0];
                correctionC1 = C[1];
                ansD = D[0];
                correctionD1 = D[1];
            } catch (Exception e) {
                System.out.println(e);
            }

            final String correctionA = correctionA1;
            final String correctionB = correctionB1;
            final String correctionC = correctionC1;
            final String correctionD = correctionD1;

            Text ask = new Text(question);
            questionGrid.add(ask, 0, 0);

            Button btn1 = new Button(ansA);
            HBox hbBtn1 = new HBox(10);
            hbBtn1.setAlignment(Pos.BOTTOM_LEFT);
            hbBtn1.getChildren().add(btn1);
            questionGrid.add(hbBtn1, 0, 1);

            Button btn2 = new Button(ansB);
            HBox hbBtn2 = new HBox(10);
            hbBtn2.setAlignment(Pos.BOTTOM_LEFT);
            hbBtn2.getChildren().add(btn2);
            questionGrid.add(hbBtn2, 0, 2);

            Button btn3 = new Button(ansC);
            HBox hbBtn3 = new HBox(10);
            hbBtn3.setAlignment(Pos.BOTTOM_LEFT);
            hbBtn3.getChildren().add(btn3);
            questionGrid.add(hbBtn3, 0, 3);

            Button btn4 = new Button(ansD);
            HBox hbBtn4 = new HBox(10);
            hbBtn4.setAlignment(Pos.BOTTOM_LEFT);
            hbBtn4.getChildren().add(btn4);
            questionGrid.add(hbBtn4, 0, 4);

            Button next = new Button("Next");
            HBox hbNext = new HBox(10);
            hbNext.setAlignment(Pos.BOTTOM_LEFT);
            hbNext.getChildren().add(next);

            next.setOnAction((event) -> {
                newQuestion = true;
                questionGrid.getChildren().clear();
                questionNum++;
                if(in.hasNext())
                {
                    setNewQuestion(in, primaryStage);
                }
                else
                {
                    end(primaryStage, questionGrid);
                }
            });
            btn1.setOnAction((event) -> {
                try {
                    Text wrongText = new Text(correctionA);
                    questionGrid.add(wrongText, 1, 1);
                    questionGrid.add(hbNext, 1, 5);
                    if(correctionA.equals("Correct"))
                    {
                        correctQuestions++;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Don't care");
                }
            });

            btn2.setOnAction((event) -> {
                try {
                    Text wrongText = new Text(correctionB);
                    questionGrid.add(wrongText, 1, 1);
                    questionGrid.add(hbNext, 1, 5);
                    if(correctionB.equals("Correct"))
                    {
                        correctQuestions++;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Don't care");
                }
            });

            btn3.setOnAction((event) -> {
                try {
                    Text wrongText = new Text(correctionC);
                    questionGrid.add(wrongText, 1, 1);
                    questionGrid.add(hbNext, 1, 5);
                    if(correctionC.equals("Correct"))
                    {
                        correctQuestions++;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Don't care");
                }
            });

            btn4.setOnAction((event) -> {
                try {
                    Text correctText = new Text(correctionD);
                    questionGrid.add(correctText, 1, 1);
                    questionGrid.add(hbNext, 1, 5);
                    if(correctionD.equals("Correct"))
                    {
                        correctQuestions++;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Don't care");
                }
            });
            Scene scene2 = new Scene(questionGrid, 800, 400);
            primaryStage.setScene(scene2);
            primaryStage.show();
        }
    }
    public void end(Stage primaryStage, GridPane grid)
    {
        double percent = (100.0*correctQuestions)/questionNum;
        Text text = new Text("Your Score: "+percent+"%");
        grid.add(text,0,0);
        try {
            bw.write("Score: " + percent + "%");
            bw.newLine();
            bw.close();
        }
        catch (Exception e) {
            System.out.println("Don't care");
        }
        primaryStage.show();
    }
    public void setPlaying(boolean state)
    {
        this.playing = state;
    }
    public boolean getPlaying() {
        return this.playing;
    }
}
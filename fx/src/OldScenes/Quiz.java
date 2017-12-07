 package OldScenes;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

 public class Quiz
{
    boolean newQuestion = true;
    int correctQuestions = 0;
    int questionNum = 0;
    double percent = 0;

    public Quiz()
    {

    }

    public void run(Stage primaryStage, String fileName)
    {
        Scanner in = new Scanner(System.in);
        try {
            in = new Scanner(new File(fileName));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        setNewQuestion(in, primaryStage);
    }

    public void setNewQuestion(Scanner in, Stage primaryStage)
    {
        GridPane grid = new GridPane();
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
            grid.add(ask, 0, 0);

            Button btn1 = new Button(ansA);
            HBox hbBtn1 = new HBox(10);
            hbBtn1.setAlignment(Pos.BOTTOM_LEFT);
            hbBtn1.getChildren().add(btn1);
            grid.add(hbBtn1, 0, 1);

            Button btn2 = new Button(ansB);
            HBox hbBtn2 = new HBox(10);
            hbBtn2.setAlignment(Pos.BOTTOM_LEFT);
            hbBtn2.getChildren().add(btn2);
            grid.add(hbBtn2, 0, 2);

            Button btn3 = new Button(ansC);
            HBox hbBtn3 = new HBox(10);
            hbBtn3.setAlignment(Pos.BOTTOM_LEFT);
            hbBtn3.getChildren().add(btn3);
            grid.add(hbBtn3, 0, 3);

            Button btn4 = new Button(ansD);
            HBox hbBtn4 = new HBox(10);
            hbBtn4.setAlignment(Pos.BOTTOM_LEFT);
            hbBtn4.getChildren().add(btn4);
            grid.add(hbBtn4, 0, 4);

            Button next = new Button("Next");
            HBox hbNext = new HBox(10);
            hbNext.setAlignment(Pos.BOTTOM_LEFT);
            hbNext.getChildren().add(next);

            next.setOnAction((event) -> {
                newQuestion = true;
                grid.getChildren().clear();
                questionNum++;
                if(in.hasNext())
                {
                    setNewQuestion(in, primaryStage);
                }
                else
                {
                    percent = correctQuestions*100.0/questionNum;
                    SceneDriver.nextScene();
                }
            });

            btn1.setOnAction((event) -> {
                try {
                    Text wrongText = new Text(correctionA);
                    grid.add(wrongText, 1, 1);
                    grid.add(hbNext, 1, 5);
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
                    grid.add(wrongText, 1, 1);
                    grid.add(hbNext, 1, 5);
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
                    grid.add(wrongText, 1, 1);
                    grid.add(hbNext, 1, 5);
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
                    grid.add(correctText, 1, 1);
                    grid.add(hbNext, 1, 5);
                    if(correctionD.equals("Correct"))
                    {
                        correctQuestions++;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Don't care");
                }
            });

            Scene scene2 = new Scene(grid, 800, 400);
            primaryStage.setScene(scene2);

            primaryStage.show();
        }
    }

    public double getPercent()
    {
        return percent;
    }
}

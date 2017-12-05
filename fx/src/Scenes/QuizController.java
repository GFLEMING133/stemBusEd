package Scenes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import java.io.File;
import java.util.Scanner;

/**
 * WARNING: Janky Code Ahead
 */

public class QuizController {
    @FXML private Text question;
    @FXML private RadioButton answer1;
    @FXML private RadioButton answer2;
    @FXML private RadioButton answer3;
    @FXML private RadioButton answer4;
    @FXML Button button;
    @FXML Button nextButton;

    private boolean wasSelected1 = false;
    private boolean wasSelected2 = false;
    private boolean wasSelected3 = false;
    private boolean wasSelected4 = false;

    private MediaTests mt = new MediaTests();
    private String path = mt.quizPath;
    private int correctAnswer = -1;
    private Scanner in;
    private int numCorrect = 0;
    private String reasons[] = new String[4];
    private int totalQ = 0;

    public void initialize(MediaTests mediaTests) {
        mt = mediaTests;
        System.out.println("Started the quiz controller");
        nextButton.setText("Next Question");

        try {
            in = new Scanner(new File(path));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        setNewQuestion();
    }

    public void setNewQuestion()
    {
        button.setVisible(true);
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        answer4.setVisible(true);
        nextButton.setVisible(false);

        if(in.hasNext()) {
            totalQ++;
            question.setText(in.nextLine());

            String a1[] = in.nextLine().split("\t");
            String a2[] = in.nextLine().split("\t");
            String a3[] = in.nextLine().split("\t");
            String a4[] = in.nextLine().split("\t");
            answer1.setText(a1[0]);
            answer2.setText(a2[0]);
            answer3.setText(a3[0]);
            answer4.setText(a4[0]);
            reasons[0] = a1[1];
            reasons[1] = a2[1];
            reasons[2] = a3[1];
            reasons[3] = a4[1];

            if (a1[1].equals("Correct")) {
                correctAnswer = 1;
            } else if (a2[1].equals("Correct")) {
                correctAnswer = 2;
            } else if (a3[1].equals("Correct")) {
                correctAnswer = 3;
            } else {
                correctAnswer = 4;
            }
        }
        else
        {
            mt.numCorrect = numCorrect;
            mt.totalQuestions = totalQ;
            System.out.println("Correct: "+numCorrect);
            mt.moveToResultsScene();
        }
    }

    public void checkAnswer()
    {
        int answer = -1;
        if(answer1.isSelected())
        {
            answer = 1;
        }
        else if(answer2.isSelected())
        {
            answer = 2;
        }
        else if(answer3.isSelected())
        {
            answer = 3;
        }
        else if(answer4.isSelected())
        {
            answer = 4;
        }

        if(answer == correctAnswer)
        {
            answer1.setSelected(false);
            answer2.setSelected(false);
            answer3.setSelected(false);
            answer4.setSelected(false);

            numCorrect++;
            seeResults(answer-1);
        }
        else if(answer == -1)
        {}
        else
        {
            answer1.setSelected(false);
            answer2.setSelected(false);
            answer3.setSelected(false);
            answer4.setSelected(false);

            seeResults(answer-1);
        }
    }

    public void newClick()
    {
        if(answer1.isSelected() && !wasSelected1)
        {
            wasSelected1 = true;

            wasSelected2 = false;
            wasSelected3 = false;
            wasSelected4 = false;

            answer2.setSelected(false);
            answer3.setSelected(false);
            answer4.setSelected(false);
        }
        else if(answer2.isSelected() && !wasSelected2)
        {
            wasSelected2 = true;

            wasSelected1 = false;
            wasSelected3 = false;
            wasSelected4 = false;

            answer1.setSelected(false);
            answer3.setSelected(false);
            answer4.setSelected(false);
        }
        else if(answer3.isSelected() && !wasSelected3)
        {
            wasSelected3 = true;

            wasSelected1 = false;
            wasSelected2 = false;
            wasSelected4 = false;

            answer1.setSelected(false);
            answer2.setSelected(false);
            answer4.setSelected(false);
        }
        else if(answer4.isSelected() && !wasSelected4)
        {
            wasSelected4 = true;

            wasSelected1 = false;
            wasSelected2 = false;
            wasSelected3 = false;

            answer1.setSelected(false);
            answer2.setSelected(false);
            answer3.setSelected(false);
        }
    }

    public void seeResults(int answer)
    {
        button.setVisible(false);
        answer1.setVisible(false);
        answer2.setVisible(false);
        answer3.setVisible(false);
        answer4.setVisible(false);
        nextButton.setVisible(true);
        String display = "Your answer: ";
        if(answer==0)
        {
            display += answer1.getText();
        }
        else if(answer==1)
        {
            display += answer2.getText();
        }
        else if(answer==2)
        {
            display += answer3.getText();
        }
        else
        {
            display += answer4.getText();
        }
        display += "\nCorrect answer: ";

        if(correctAnswer==1)
        {
            display += answer1.getText();
        }
        else if(correctAnswer==2)
        {
            display += answer2.getText();
        }
        else if(correctAnswer==3)
        {
            display += answer3.getText();
        }
        else
        {
            display += answer4.getText();
        }

        question.setText(display+"\n"+reasons[answer]);
    }
}

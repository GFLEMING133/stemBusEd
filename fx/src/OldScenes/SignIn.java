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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

 public class SignIn
{
    BufferedWriter bw;
    String name;
    boolean done = false;

    public SignIn(Stage primaryStage)
    {

    }

    public void run(Stage primaryStage)
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 1024, 768);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Welcome");
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

            done = true;
            SceneDriver.nextScene();
        });
    }

    public boolean isDone()
    {
        return done;
    }

    public String getName()
    {
        return name;
    }
}

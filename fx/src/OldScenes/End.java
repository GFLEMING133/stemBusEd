 package OldScenes;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class End
{
    public End()
    {

    }

    public void run(Stage primaryStage, double percent)
    {
        GridPane grid = new GridPane();
        Text text = new Text("Your Score: "+percent+"%");
        grid.add(text,1,1);
        Scene scene = new Scene(grid, 1024, 768);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

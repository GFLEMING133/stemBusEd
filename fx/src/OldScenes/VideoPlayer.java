 package OldScenes;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import java.nio.file.Paths;


 public class VideoPlayer
{
    boolean playing = false;

    public VideoPlayer()
    {

    }

    public void run(Stage primaryStage, String fileName)
    {
        Button playButton = new Button("Play the video!");
        Button btn = new Button("Go to quiz!");
        MediaPlayer player = new MediaPlayer(new Media(Paths.get(fileName).toUri().toString()));
        MediaView mediaView = new MediaView(player);
        GridPane grid = new GridPane();

        grid.getChildren().clear();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(mediaView, 0,0);
        grid.add(playButton, 1,1);
        grid.add(btn, 1,0);
        Scene scene1 = new Scene(grid, 1024, 768);

        primaryStage.setScene(scene1);

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
            SceneDriver.nextScene();
        });
    }

    public void setPlaying(boolean state)
    {
        this.playing = state;
    }

    public boolean getPlaying()
    {
        return this.playing;
    }
}

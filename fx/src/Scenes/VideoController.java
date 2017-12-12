package Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.control.Button;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.Timer;

/**
 * WARNING: To preserve your sanity, don't read the code below
 */

public class VideoController {
    @FXML GridPane innerGrid;
    @FXML Button quizButton;
    @FXML Button playButton;
    @FXML ImageView imView = new ImageView();
    @FXML GridPane largeGrid;

    Timer t1 = new Timer();
    MyTimerClass time;
    private boolean playing = false;
    private MediaTests mt = new MediaTests();
    private MediaPlayer player;
    double totalTime = 0;
    double pauseTime = 0;

    public void initialize(MediaTests mediaTests, String videoPath, String imagePath, Scene scene) {
        Image image = new Image(Paths.get(imagePath).toUri().toString());
        imView.setImage(image);
        largeGrid.minHeightProperty().bind(scene.heightProperty());
        largeGrid.minWidthProperty().bind(scene.widthProperty());

        player = new MediaPlayer(new Media(Paths.get(videoPath).toUri().toString()));
        mt = mediaTests;
        System.out.println("Started the video controller");
        quizButton.setVisible(false);

        player.setOnReady(new Runnable() {
            @Override
            public void run() {
                totalTime = player.getTotalDuration().toSeconds();
            }
        });
    }

    public void plausePlay() {
        if (playing) {
            player.pause();
            playing = false;

            time.stop();
            pauseTime = player.getCurrentTime().toSeconds();
        }
        else {
            player.play();
            playing = true;
            checkTime(totalTime-pauseTime);
        }
    }

    public void callToQuiz() {
        System.out.println("No problems with pressing button...");
        mt.moveToQuizScene();
    }

    public void checkTime(double timeSec)
    {
        time = new MyTimerClass();
        time.getObject(this);
        t1 = new Timer();
        t1.schedule(time, (int)timeSec*1000);
    }
}
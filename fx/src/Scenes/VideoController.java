package Scenes;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import java.nio.file.Paths;
import java.util.Timer;

/**
 * WARNING: To preserve your sanity, don't read the code below
 */

public class VideoController {
    @FXML GridPane innerGrid;
    @FXML Button quizButton;
    @FXML Button playButton;

    Timer t1 = new Timer();
    MyTimerClass time;
    private boolean playing = false;
    private MediaTests mt = new MediaTests();
    private MediaPlayer player = new MediaPlayer(new Media(Paths.get("src\\jamaicaAudio.mp3").toUri().toString()));

    double totalTime = 0;
    double pauseTime = 0;
    public void initialize(MediaTests mediaTests) {
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
    private void plausePlay() {
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
    private void callToQuiz() {
        System.out.println("No problems with pressing button...");
        mt.moveToQuizScene();
    }
    private void checkTime(double timeSec)
    {
        time = new MyTimerClass();
        time.getObject(this);
        t1 = new Timer();
        t1.schedule(time, (int)timeSec*1000);
    }
}
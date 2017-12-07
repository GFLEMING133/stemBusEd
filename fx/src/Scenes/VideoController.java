package Scenes;
import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
=======
>>>>>>> ce8611fc13c37f6b3097639a48a9aac180b38631
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
<<<<<<< HEAD
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;

=======
>>>>>>> ce8611fc13c37f6b3097639a48a9aac180b38631
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

    Timer t1 = new Timer();
    MyTimerClass time;
    private boolean playing = false;
    private MediaTests mt = new MediaTests();
<<<<<<< HEAD
    private MediaPlayer player;
    double totalTime = 0;
    double pauseTime = 0;

    public void initialize(MediaTests mediaTests, String videoPath, String imagePath) {
        Image image = new Image(Paths.get(imagePath).toUri().toString());
        imView.setImage(image);

        player = new MediaPlayer(new Media(Paths.get(videoPath).toUri().toString()));
=======
    private MediaPlayer player = new MediaPlayer(new Media(Paths.get("src\\jamaicaAudio.mp3").toUri().toString()));

    double totalTime = 0;
    double pauseTime = 0;
    public void initialize(MediaTests mediaTests) {
>>>>>>> ce8611fc13c37f6b3097639a48a9aac180b38631
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
<<<<<<< HEAD

    public void callToQuiz() {
        System.out.println("No problems with pressing button...");
        mt.moveToQuizScene();
    }

    public void checkTime(double timeSec)
=======
    private void callToQuiz() {
        System.out.println("No problems with pressing button...");
        mt.moveToQuizScene();
    }
    private void checkTime(double timeSec)
>>>>>>> ce8611fc13c37f6b3097639a48a9aac180b38631
    {
        time = new MyTimerClass();
        time.getObject(this);
        t1 = new Timer();
        t1.schedule(time, (int)timeSec*1000);
    }
}
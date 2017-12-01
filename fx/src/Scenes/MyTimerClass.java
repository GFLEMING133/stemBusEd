/*
 *SE 1011-061 2017
 *File header: Contains the class MyTimerClass
 *Name: Ethan Janecek
 *Created on 11/30/2017
 */

package Scenes;

import java.util.TimerTask;

/**
 *SE 1011-061 2017
 *Purpose: 
 *
 *@author janecekem
 *@version 1.0 Created on 11/30/2017 at 2:23 PM.
 *@formatOff
 */
public class MyTimerClass extends TimerTask
{
    VideoController video = new VideoController();
    boolean change = true;

    @Override
    public void run() {
        if(change)
        {
            video.quizButton.setVisible(true);
            video.playButton.setVisible(false);
        }
    }

    public void getObject(VideoController vid)
    {
        video = vid;
    }

    public void stop()
    {
        change = false;
    }
}

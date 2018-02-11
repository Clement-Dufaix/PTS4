package com.example.clement.pts4;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Hugo on 07/02/2018.
 */

public class Tour  {


    static float dmg = 1;
    static double cadence = 0.5 ;
    Timer timer;       //timer qui sert a afficher la vague si il n'y a plus d'ennemie
    TimerTask timerTask;   //sa tache
    ImageView missile ;
   int x;
   int y;




    public Tour(int x ,int y){
        this.x=x;
        this.y=y;
        this.dmg=dmg;
        this.cadence=cadence;
        timer = new Timer();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                Log.e("z","z");
               // attaquer();
            }
        };
        timer.schedule(timerTask, 10, (int)(cadence*1000));
    }

    public void attaquer(){
        missile.setBackgroundResource(R.drawable.missile);

        missile.setY(x);
    }

}

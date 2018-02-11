package com.example.clement.pts4;

import android.util.Log;

import com.example.clement.pts4.PathFinding.ExampleNode;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Clement on 11/02/2018.
 */

public class Monster {

    int vie = 10;
    float vitesse = (float) 0.05;
    Timer timer;       //timer qui sert a afficher la vague si il n'y a plus d'ennemie
    TimerTask timerTask;   //sa tache

    public Monster(List<ExampleNode> way, float vitesse) {
        timer = new Timer();

        timerTask = new TimerTask() {
            @Override
            public void run() {
               Log.e("z","z");

            }
        };
        timer.schedule(timerTask, 10, (int)(vitesse*1000)); //toutes les 0.3s
    }
}

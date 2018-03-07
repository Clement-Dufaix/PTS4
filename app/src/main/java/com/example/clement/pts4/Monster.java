package com.example.clement.pts4;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.clement.pts4.PathFinding.ExampleNode;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Clement on 11/02/2018.
 */

public class Monster extends Activity {

    int vie = 10;
    float vitesse = (float) 0.00005f;
    Timer timer;       //timer qui sert a afficher la vague si il n'y a plus d'ennemie
    TimerTask timerTask;   //sa tache
    MainActivity context;
    Carte carte;
    ImageView monster;
    int x=10;
    int y=10;

    public Monster(List<ExampleNode> way, float vitesse, final MainActivity context) {
        timer = new Timer();
        this.context = context;
        monster = new ImageView(context);

        monster.setImageResource(R.drawable.unite);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150, 150);
        monster.setLayoutParams(layoutParams);
        context.fenetrePrincipale.addView(monster);

        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        monster.setX(++x);
                        monster.setY(y);
                        context.fenetrePrincipale.removeView(monster);
                        context.fenetrePrincipale.addView(monster);

                    }
                });
            }
        };
        timer.schedule(timerTask, 10, (int)(vitesse*1000));
    }
}

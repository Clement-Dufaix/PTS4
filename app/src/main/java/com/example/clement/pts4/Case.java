package com.example.clement.pts4;

import android.view.View;
import android.widget.Button;

/**
 * Created by Clement on 30/01/2018.
 */

public class Case {//test push

    Button case_;
    int x;
    int y;
    int etat=0; //0 = case vide, 1 = mur, 2 = tour, 3 = case de départ, 4 = case de départ

    public Case(Button v, int x, int y){
        case_ = v;
    }

    public void setEtat(int etat){
        this.etat=etat;
    }

    public int getEtat(){
        return etat;
    }

    public View getView(){
        return case_;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

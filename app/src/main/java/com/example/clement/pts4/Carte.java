package com.example.clement.pts4;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.clement.pts4.PathFinding.ExampleNode;
import com.example.clement.pts4.PathFinding.PathFindingTool;

import java.util.List;

/**
 * Created by Clement on 06/02/2018.
 */

public class Carte {

    Case grid[][];      //tableaux de Case, dans lequel on pourra stocker chaque bouttons

    int tailleMapX = 12;
    int tailleMapY = 16;
    List<ExampleNode> way;
    PathFindingTool path;

    public Carte(Case[][] grid){
        this.grid = grid;
        path = new PathFindingTool(tailleMapX,tailleMapY);
        afficherPlusCourtChemin();
    }

    public void setTower(Button stone){
        stone.setBackgroundResource(R.drawable.black_square);
        int stoneX=0;
        int stoneY=0;
        for (int i = 0; i < tailleMapX; i++)
            for (int j = 0; j < tailleMapY; j++){
                if(stone == grid[i][j].getView()){
                    stoneX = i;
                    stoneY = j;
                    grid[i][j].setEtat(1);
                    break;
                }
            }
        path.setBlock(stoneX,stoneY,true);
        afficherPlusCourtChemin();
    }

    public void afficherPlusCourtChemin (){
        if(way!=null){
            for (int i = 0; i < way.size(); i++) {
                Log.e("debug : ", ""+ R.drawable.black_square);   //android.content.res.Resources@797147c
                //comparer avec case noir
                if(grid[way.get(i).getxPosition()][way.get(i).getyPosition()].etat!=1)
                    grid[way.get(i).getxPosition()][way.get(i).getyPosition()].getView().setBackgroundResource(R.drawable.cadre);
            }
        }
        int departX = 0;
        int departY=0;
        int arriveeX = 11;
        int arriveeY = 11;
        way = path.findPath(departX, departY, arriveeX, arriveeY);
        grid[departX][departY].getView().setBackgroundResource(R.drawable.red_square);
        grid[departX][departY].setEtat(3);
        grid[arriveeX][arriveeY].getView().setBackgroundResource(R.drawable.green_square);
        grid[arriveeX][arriveeY].setEtat(4);
        for (int i = 0; i < way.size()-1; i++) {
            grid[way.get(i).getxPosition()][way.get(i).getyPosition()].getView().setBackgroundResource(R.drawable.orange_square);
            grid[way.get(i).getxPosition()][way.get(i).getyPosition()].setEtat(2);
            Log.e("debug pathFinding : ","(" + way.get(i).getxPosition() + ", " + way.get(i).getyPosition() + ") -> ");
        }

    }
}

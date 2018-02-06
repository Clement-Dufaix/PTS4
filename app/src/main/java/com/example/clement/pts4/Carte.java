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

    int tailleMapX = 13;
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
                    if(grid[i][j].getEtat()==1) {
                        stone.setBackgroundResource(R.drawable.cadre);
                        grid[i][j].setEtat(0);
                        path.setBlock(stoneX,stoneY,false);
                    }
                   else {
                        stone.setBackgroundResource(R.drawable.black_square);
                        grid[i][j].setEtat(1);
                        path.setBlock(stoneX,stoneY,true);
                    }
                    break;
                }
            }
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
        int departY=1;
        int arriveeX = 11;
        int arriveeY = 14;
        way = path.findPath(departX, departY, arriveeX, arriveeY);
        grid[departX][departY].getView().setBackgroundResource(R.drawable.red_square);
        grid[departX][departY].setEtat(3);
        grid[arriveeX][arriveeY].getView().setBackgroundResource(R.drawable.green_square);
        grid[arriveeX][arriveeY].setEtat(4);
        for (int i = 0; i < way.size()-1; i++) {
            grid[way.get(i).getxPosition()][way.get(i).getyPosition()].getView().setBackgroundResource(R.drawable.orange_square);
           // grid[way.get(i).getxPosition()][way.get(i).getyPosition()].setEtat(2);
            Log.e("debug pathFinding : ","(" + way.get(i).getxPosition() + ", " + way.get(i).getyPosition() + ") -> ");
        }

    }

    public void setCarteDefaut1(){

        grid[4][0].setEtat(1);
        grid[4][1].setEtat(1);
        grid[4][3].setEtat(1);
        grid[4][4].setEtat(1);
        grid[0][4].setEtat(1);
        grid[1][4].setEtat(1);
        grid[2][4].setEtat(1);
        grid[3][4].setEtat(1);
        grid[7][0].setEtat(1);
        grid[7][1].setEtat(1);
        grid[7][2].setEtat(1);
        grid[7][5].setEtat(1);
        grid[7][6].setEtat(1);
        grid[7][7].setEtat(1);
        grid[8][7].setEtat(1);
        grid[9][7].setEtat(1);
        grid[11][7].setEtat(1);
        grid[12][7].setEtat(1);
        grid[6][7].setEtat(1);
        grid[5][7].setEtat(1);
        grid[4][7].setEtat(1);
        grid[4][6].setEtat(1);
        grid[4][8].setEtat(1);
        grid[4][9].setEtat(1);
        grid[4][10].setEtat(1);
        grid[4][11].setEtat(1);
        grid[4][12].setEtat(1);
        grid[4][15].setEtat(1);
        grid[3][9].setEtat(1);
        grid[1][9].setEtat(1);
        grid[0][9].setEtat(1);
        grid[12][10].setEtat(1);
        grid[11][10].setEtat(1);
        grid[10][10].setEtat(1);
        grid[9][10].setEtat(1);
        grid[8][10].setEtat(1);
        grid[7][10].setEtat(1);
        grid[7][11].setEtat(1);
        grid[7][13].setEtat(1);
        grid[7][14].setEtat(1);
        grid[7][15].setEtat(1);

        rafraichirMap();
    }

    public void rafraichirMap(){    //Fonction qui peut créer des latences!!!!!
        for (int y = 0; y < tailleMapY; y++)
            for (int x = 0; x < tailleMapX; x++){
                switch(grid[x][y].getEtat()){
                    case 0 : grid[x][y].getView().setBackgroundResource(R.drawable.cadre);
                    path.setBlock(x,y,false);
                    break;
                    case 1 : grid[x][y].getView().setBackgroundResource(R.drawable.black_square);
                        path.setBlock(x,y,true);
                        break;
                    case 2 : grid[x][y].getView().setBackgroundResource(R.drawable.black_square);    //TODO : image tour a créer
                        path.setBlock(x,y,false);
                    break;
                    case 3 : grid[x][y].getView().setBackgroundResource(R.drawable.green_square);
                        path.setBlock(x,y,false);
                    break;
                    case 4 : grid[x][y].getView().setBackgroundResource(R.drawable.red_square);
                        path.setBlock(x,y,false);
                    break;
                    default : grid[x][y].getView().setBackgroundResource(R.drawable.cadre);
                        path.setBlock(x,y,false);
                    break;
                }
            }
            afficherPlusCourtChemin();
        }

}

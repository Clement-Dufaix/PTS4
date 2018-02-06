package com.example.clement.pts4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.clement.pts4.PathFinding.ExampleNode;
import com.example.clement.pts4.PathFinding.PathFindingTool;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Case grid[][];      //tableaux de Case, dans lequel on pourra stocker chaque bouttons
    int board[][] =     //contient les id des bouttons
            {
                    {R.id.stone00, R.id.stone01, R.id.stone02, R.id.stone03, R.id.stone04, R.id.stone05, R.id.stone06, R.id.stone07, R.id.stone08, R.id.stone09,
                            R.id.stone0a, R.id.stone0b, R.id.stone0c, R.id.stone0d, R.id.stone0e, R.id.stone0f, R.id.stone0g, R.id.stone0h, R.id.stone0i, R.id.stone0j},
                    {R.id.stone10, R.id.stone11, R.id.stone12, R.id.stone13, R.id.stone14, R.id.stone15, R.id.stone16, R.id.stone17, R.id.stone18, R.id.stone19,
                            R.id.stone1a, R.id.stone1b, R.id.stone1c, R.id.stone1d, R.id.stone1e, R.id.stone1f, R.id.stone1g, R.id.stone1h, R.id.stone1i, R.id.stone1j},
                    {R.id.stone20, R.id.stone21, R.id.stone22, R.id.stone23, R.id.stone24, R.id.stone25, R.id.stone26, R.id.stone27, R.id.stone28, R.id.stone29,
                            R.id.stone2a, R.id.stone2b, R.id.stone2c, R.id.stone2d, R.id.stone2e, R.id.stone2f, R.id.stone2g, R.id.stone2h, R.id.stone2i, R.id.stone2j},
                    {R.id.stone30, R.id.stone31, R.id.stone32, R.id.stone33, R.id.stone34, R.id.stone35, R.id.stone36, R.id.stone37, R.id.stone38, R.id.stone39,
                            R.id.stone3a, R.id.stone3b, R.id.stone3c, R.id.stone3d, R.id.stone3e, R.id.stone3f, R.id.stone3g, R.id.stone3h, R.id.stone3i, R.id.stone3j},
                    {R.id.stone40, R.id.stone41, R.id.stone42, R.id.stone43, R.id.stone44, R.id.stone45, R.id.stone46, R.id.stone47, R.id.stone48, R.id.stone49,
                            R.id.stone4a, R.id.stone4b, R.id.stone4c, R.id.stone4d, R.id.stone4e, R.id.stone4f, R.id.stone4g, R.id.stone4h, R.id.stone4i, R.id.stone4j},
                    {R.id.stone50, R.id.stone51, R.id.stone52, R.id.stone53, R.id.stone54, R.id.stone55, R.id.stone56, R.id.stone57, R.id.stone58, R.id.stone59,
                            R.id.stone5a, R.id.stone5b, R.id.stone5c, R.id.stone5d, R.id.stone5e, R.id.stone5f, R.id.stone5g, R.id.stone5h, R.id.stone5i, R.id.stone5j},
                    {R.id.stone60, R.id.stone61, R.id.stone62, R.id.stone63, R.id.stone64, R.id.stone65, R.id.stone66, R.id.stone67, R.id.stone68, R.id.stone69,
                            R.id.stone6a, R.id.stone6b, R.id.stone6c, R.id.stone6d, R.id.stone6e, R.id.stone6f, R.id.stone6g, R.id.stone6h, R.id.stone6i, R.id.stone6j},
                    {R.id.stone70, R.id.stone71, R.id.stone72, R.id.stone73, R.id.stone74, R.id.stone75, R.id.stone76, R.id.stone77, R.id.stone78, R.id.stone79,
                            R.id.stone7a, R.id.stone7b, R.id.stone7c, R.id.stone7d, R.id.stone7e, R.id.stone7f, R.id.stone7g, R.id.stone7h, R.id.stone7i, R.id.stone7j},
                    {R.id.stone80, R.id.stone81, R.id.stone82, R.id.stone83, R.id.stone84, R.id.stone85, R.id.stone86, R.id.stone87, R.id.stone88, R.id.stone89,
                            R.id.stone8a, R.id.stone8b, R.id.stone8c, R.id.stone8d, R.id.stone8e, R.id.stone8f, R.id.stone8g, R.id.stone8h, R.id.stone8i, R.id.stone8j},
                    {R.id.stone90, R.id.stone91, R.id.stone92, R.id.stone93, R.id.stone94, R.id.stone95, R.id.stone96, R.id.stone97, R.id.stone98, R.id.stone99,
                            R.id.stone9a, R.id.stone9b, R.id.stone9c, R.id.stone9d, R.id.stone9e, R.id.stone9f, R.id.stone9g, R.id.stone9h, R.id.stone9i, R.id.stone9j},
                    {R.id.stonea0, R.id.stonea1, R.id.stonea2, R.id.stonea3, R.id.stonea4, R.id.stonea5, R.id.stonea6, R.id.stonea7, R.id.stonea8, R.id.stonea9,
                            R.id.stoneaa, R.id.stoneab, R.id.stoneac, R.id.stonead, R.id.stoneae, R.id.stoneaf, R.id.stoneag, R.id.stoneah, R.id.stoneai, R.id.stoneaj},
                    {R.id.stoneb0, R.id.stoneb1, R.id.stoneb2, R.id.stoneb3, R.id.stoneb4, R.id.stoneb5, R.id.stoneb6, R.id.stoneb7, R.id.stoneb8, R.id.stoneb9,
                            R.id.stoneba, R.id.stonebb, R.id.stonebc, R.id.stonebd, R.id.stonebe, R.id.stonebf, R.id.stonebg, R.id.stonebh, R.id.stonebi, R.id.stonebj},
                    {R.id.stonec0, R.id.stonec1, R.id.stonec2, R.id.stonec3, R.id.stonec4, R.id.stonec5, R.id.stonec6, R.id.stonec7, R.id.stonec8, R.id.stonec9,
                            R.id.stoneca, R.id.stonecb, R.id.stonecc, R.id.stonecd, R.id.stonece, R.id.stonecf, R.id.stonecg, R.id.stonech, R.id.stoneci, R.id.stonecj},
                    {R.id.stoned0, R.id.stoned1, R.id.stoned2, R.id.stoned3, R.id.stoned4, R.id.stoned5, R.id.stoned6, R.id.stoned7, R.id.stoned8, R.id.stoned9,
                            R.id.stoneda, R.id.stonedb, R.id.stonedc, R.id.stonedd, R.id.stonede, R.id.stonedf, R.id.stonedg, R.id.stonedh, R.id.stonedi, R.id.stonedj},
                    {R.id.stonee0, R.id.stonee1, R.id.stonee2, R.id.stonee3, R.id.stonee4, R.id.stonee5, R.id.stonee6, R.id.stonee7, R.id.stonee8, R.id.stonee9,
                            R.id.stoneea, R.id.stoneeb, R.id.stoneec, R.id.stoneed, R.id.stoneee, R.id.stoneef, R.id.stoneeg, R.id.stoneeh, R.id.stoneei, R.id.stoneej},
                    {R.id.stonef0, R.id.stonef1, R.id.stonef2, R.id.stonef3, R.id.stonef4, R.id.stonef5, R.id.stonef6, R.id.stonef7, R.id.stonef8, R.id.stonef9,
                            R.id.stonefa, R.id.stonefb, R.id.stonefc, R.id.stonefd, R.id.stonefe, R.id.stoneff, R.id.stonefg, R.id.stonefh, R.id.stonefi, R.id.stonefj},
            };

    PathFindingTool path;
    List<ExampleNode> way;
    int tailleMapX = 12;
    int tailleMapY = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //findViewById(board[0][0]).setTag(1,1);
        grid = new Case[tailleMapX][tailleMapY];
       for(int y=0;y<tailleMapY;y++){
           for(int x=0;x<tailleMapX;x++){
               Log.e("bug!!!", "onCreate: " );
                grid[x][y]= new Case((Button)findViewById(board[y][x]),x,y);
           }
       }
        path = new PathFindingTool(tailleMapX,tailleMapY);
        afficherPlusCourtChemin();

    }

    public void onButtonClicked(View view) {
        Button stone = (Button) view;
        stone.setBackgroundResource(R.drawable.black_square);
       // stone.setTag(1,"1");
        View v;
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
        path.isBlock(stoneX,stoneY,true);
        afficherPlusCourtChemin();
    }

    private void afficherPlusCourtChemin(){
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

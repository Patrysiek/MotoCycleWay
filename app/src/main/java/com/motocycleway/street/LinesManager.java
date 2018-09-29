package com.motocycleway.street;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.motocycleway.activities.SettingsActivity;
import com.motocycleway.main.GameView;

import java.util.ArrayList;

public class LinesManager {
    private Bitmap bitmap;

    private ArrayList<Line> lines;
    private int lineWidth = SettingsActivity.WIDTH/30;
    private int lineheight = SettingsActivity.HEIGHT/6;
    private int rCoordX = SettingsActivity.WIDTH*3/4+lineWidth;
    private int lCoordX = SettingsActivity.WIDTH/4-lineWidth*2;
    private float yVelo = GameView.motobike.getSpeed()/2;

    public LinesManager(Bitmap bitmap){
        this.bitmap = Bitmap.createScaledBitmap(bitmap, lineWidth,lineheight,false);
        initLines();
    }

    private void initLines(){
        lines = new ArrayList<>();
        for(int i = 0; i<7; i++){
            lines.add(new Line(bitmap));
            lines.get(i).coordY = i*lineheight;
        }
    }
    public void draw(Canvas canvas){
        createLine(canvas,rCoordX);
        createLine(canvas,lCoordX);
    }


    private void createLine(Canvas canvas , int coordX){
        for(Line l : lines){
            l.coordX = coordX;
          l.coordY+=yVelo;
            l.draw(canvas);

            if(l.coordY>SettingsActivity.HEIGHT)
                l.coordY=(0-lineheight+yVelo);
        }
    }


    public void update(){
        yVelo = GameView.motobike.getSpeed()/2;
    }

}

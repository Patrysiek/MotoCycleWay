package com.motocycleway.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.motocycleway.activities.SettingsActivity;
import com.motocycleway.main.GameView;

public class ObstacleCar {


    float x,y = 0;
    float yVelo;
    private Bitmap bitmap;
    private float[] xPositions = {SettingsActivity.WIDTH/4-getWidth(),SettingsActivity.WIDTH/2-getWidth(),
    SettingsActivity.WIDTH/2+getWidth(),SettingsActivity.WIDTH*3/4+getWidth()};
    public ObstacleCar(Bitmap bitmap){

        this.bitmap=Bitmap.createScaledBitmap(bitmap, SettingsActivity.WIDTH/5,SettingsActivity.HEIGHT/4,false);
        this.yVelo += GameView.motobike.getyVelocity();
    }



    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }

    public void update(){
        y+=yVelo;
    }

    public float getHeight(){
        return this.bitmap.getHeight();
    }
    public float getWidth(){
        return this.bitmap.getWidth();
    }

    public float getxPositions(int i ) {
        return xPositions[i];
    }
}

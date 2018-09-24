package com.motocycleway.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.motocycleway.activities.SettingsActivity;
import com.motocycleway.main.GameView;

public class ObstacleCar {


    private  float x,y = 0;
    float yVelo = 2;
    private Bitmap bitmap;

    public ObstacleCar(Bitmap bitmap){

        this.bitmap=bitmap;
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
        if(bitmap!=null)
            return this.bitmap.getWidth();
        else
            return 0;
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getyVelo() {
        return yVelo;
    }

    public void setyVelo(float yVelo) {
        this.yVelo = yVelo;
    }
}

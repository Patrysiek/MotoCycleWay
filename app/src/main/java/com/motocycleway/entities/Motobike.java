package com.motocycleway.entities;


import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.motocycleway.activities.SettingsActivity;


public class Motobike {

    Bitmap bitmap;
    private float x;
    private float y;
    private float yVelocity = 3;
    private float deltaPosition = SettingsActivity.WIDTH/5;
    private int positionPoint = 0;
    public Motobike(Bitmap bitmap){
        this.bitmap = Bitmap.createScaledBitmap(bitmap, SettingsActivity.WIDTH/8,SettingsActivity.HEIGHT/5,false);
        x = SettingsActivity.WIDTH/2-bitmap.getWidth()/2;
        y =SettingsActivity.HEIGHT-bitmap.getHeight()-20;

    }



    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }


    public float getyVelocity() {
        return yVelocity;
    }



    public void update(){
        if(yVelocity<50) {
            yVelocity += (float) Math.log(yVelocity);

        }
    }
    public void changeLeftPosition(){
        if(x>deltaPosition){
            x-=deltaPosition;
            positionPoint--;
        }

    }
    public void changeRightPosition(){
        if(x< SettingsActivity.WIDTH -deltaPosition){
            x+=deltaPosition;
            positionPoint++;
        }

    }

    public int getPositionPoint() {
        return positionPoint;
    }
}

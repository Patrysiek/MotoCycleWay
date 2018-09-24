package com.motocycleway.entities;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import com.motocycleway.activities.SettingsActivity;

public class Motobike {

    Bitmap bitmap;
    private float x;
    private float y;
    private float xVelocity;
    private float yVelocity = 5;
    public Motobike(Bitmap bitmap){
        this.bitmap = Bitmap.createScaledBitmap(bitmap, SettingsActivity.WIDTH/8,SettingsActivity.HEIGHT/5,false);
        x = Resources.getSystem().getDisplayMetrics().widthPixels/2;
        y = Resources.getSystem().getDisplayMetrics().heightPixels-bitmap.getHeight()-100;

    }



    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public float getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }
}

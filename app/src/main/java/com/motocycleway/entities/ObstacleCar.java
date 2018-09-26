package com.motocycleway.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.motocycleway.activities.SettingsActivity;

public class ObstacleCar {


    private float x,y;
    private float velocity;
    private Bitmap bitmap;
    private int id;
    ObstacleCar(Bitmap bitmap,int id){
        this.id = id;
        this.bitmap=bitmap;
    }


    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }


    public boolean equals(ObstacleCar car) {
        if(this.id == car.id) return true;
        else return false;
    }

    public boolean overlaps(ObstacleCar car1) {
        if(!this.equals(car1)) {
            if (this.x == car1.getX()) {
                if (((  (this.y + this.getHeight()) > car1.getY() && (this.y + this.getHeight()) < car1.getY() + car1.getHeight()  )) ||
                        ((this.y > car1.getY() && this.y < (car1.getY() + car1.getHeight()) ))) {
                    this.y = SettingsActivity.HEIGHT;
                    return true;
                }
            }
        }
        return false;
    }



    public float getHeight(){
        return this.bitmap.getHeight();
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

    public float getVelocity() {
        return velocity;
    }
    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }
    public float getX(){
        return x;
    }
}

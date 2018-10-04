package com.motocycleway.entities;


import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.motocycleway.activities.SettingsActivity;


public class Motobike {

    private Bitmap bitmap;
    private float x;
    private float y;
    private float speed = 3;
    private float velocity = 1f;
    private float deltaPosition = SettingsActivity.WIDTH/5;
    private int positionPoint = 0;
    public Motobike(Bitmap bitmap){
        this.bitmap = Bitmap.createScaledBitmap(bitmap, SettingsActivity.WIDTH/8,SettingsActivity.HEIGHT/5,false);
        x = SettingsActivity.WIDTH/2-bitmap.getWidth()/2;
        y =SettingsActivity.HEIGHT-bitmap.getHeight()-bitmap.getHeight()/2;

    }



    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }


    public float getSpeed() {
        return speed;
    }



    public void update(){
        if(speed <90 && velocity>0) {
            speed +=velocity;
            velocity -=0.001f;
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



    public boolean overlaps(ObstacleCar car) {

        if(this.x <= car.getX() && this.x>=(car.getX()+car.getX()+car.getWidth()) ||
                (this.x+this.bitmap.getWidth())>car.getX()&&(this.x+this.bitmap.getWidth())<(car.getX()+car.getWidth())) {
            if ((this.y-50 + this.bitmap.getHeight()) > car.getY() && (this.y-50 + this.bitmap.getHeight()) < (car.getY() + car.getHeight()) ||
                    this.y+50 > car.getY() && this.y+50 < (car.getY() + car.getHeight())) {
                return true;
            }
        }
        return false;
    }
}

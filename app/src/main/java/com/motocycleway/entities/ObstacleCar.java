package com.motocycleway.entities;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class ObstacleCar {


    private float x,y;
    private float velocity;
    private Bitmap bitmap;
    private int id;
    public ObstacleCar(Bitmap bitmap,int id){
        this.id = id;
        this.bitmap=bitmap;
    }
    public ObstacleCar(Bitmap bitmap,float velocity, float x,float y,int id) {
        this.bitmap = bitmap;
        this.id = id;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }


    public boolean equals(ObstacleCar car) {
       return this.id == car.id;
    }

    public boolean overlaps(ObstacleCar car1) {
        if(!this.equals(car1)) {
            if (this.x == car1.getX()) {
                if (((  (this.y + this.getHeight()) > car1.getY() && (this.y + this.getHeight()) < car1.getY() + car1.getHeight()  )) ||
                        ((this.y > car1.getY() && this.y < (car1.getY() + car1.getHeight()) ))) {
                    return true;
                }
            }
        }
        return false;
    }



    public float getHeight(){
        return this.bitmap.getHeight();
    }
    public float getWidth(){
        return this.bitmap.getWidth();
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

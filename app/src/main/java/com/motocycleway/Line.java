package com.motocycleway;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Line {


    Bitmap bitmap;

    float x = 0,y=0;
    public Line(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Line(Bitmap bitmap,float x,float y) {
        this.bitmap = bitmap;
        this.x = x;
        this.y =y;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }



    ///////////////////////////////GETTERS&&SETTERS//////////////////////////////////////
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
        public float getHeight(){
        return this.bitmap.getHeight();
    }


}
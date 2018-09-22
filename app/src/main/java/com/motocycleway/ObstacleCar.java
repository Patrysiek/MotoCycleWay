package com.motocycleway;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class ObstacleCar {


    float x,y;
    float xVelo,yVelo;
    private Bitmap bitmap;
    public ObstacleCar(Bitmap bitmap){
        this.bitmap = bitmap;
    }



    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
    }

    public void update(){
        y++;
    }
}

package com.motocycleway.street;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Line {

    float coordX,coordY;

    Bitmap bitmap;
    public Line(Bitmap bitmap){
        this.bitmap = bitmap;
    }



    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,coordX,coordY,null);

    }
}

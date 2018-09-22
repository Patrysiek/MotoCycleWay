package com.motocycleway;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

public class Motobike {

    Bitmap bitmap;
    private float x;
    private float y;
    private int xVelocity;
    public Motobike(Bitmap bitmap){
        this.bitmap = bitmap;
        x = Resources.getSystem().getDisplayMetrics().widthPixels/2;
        y = Resources.getSystem().getDisplayMetrics().heightPixels-bitmap.getHeight();
    }



    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap,x,y,null);
        Log.i("rysuje","rysuje "+x);
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }
}

package com.motocycleway;


import android.content.res.Resources;
import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


public class Street {
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    private float[] linesCoords = {
            screenWidth/2f-1,screenHeight/1f,screenWidth/2f-1,0,
            screenWidth/2f+1,screenHeight/1f,screenWidth/2f+1,0,

    };

    private Bitmap bitmap;


    public Street(Bitmap bitmap){
        this.bitmap=bitmap;
    }

    public void draw(Canvas canvas){
        Paint p =  new Paint();
        Paint r = new Paint();
        p.setColor(Color.WHITE);
        r.setColor(Color.GRAY);
        canvas.drawColor(Color.GRAY);
        canvas.drawRect(new Rect(screenWidth/2-30,0,screenWidth/2+30,screenHeight),p);
        canvas.drawRect(new Rect(screenWidth/2-10,0,screenWidth/2+10,screenHeight),r);
    }

}







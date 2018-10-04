package com.motocycleway.main;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.motocycleway.activities.SettingsActivity;

public class GameOver {

    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private String text;
    public GameOver(SurfaceHolder surfaceHolder,String loserText){
        this.surfaceHolder = surfaceHolder;
        text = loserText;
        paint = new Paint(Color.RED);
        paint.setTextSize(100);
        draw();
    }




    private void draw(){
        surfaceHolder.lockCanvas();
        MainThread.canvas.drawText(text,SettingsActivity.WIDTH/2,SettingsActivity.HEIGHT/2 ,paint);
    surfaceHolder.unlockCanvasAndPost(MainThread.canvas);
    }

}

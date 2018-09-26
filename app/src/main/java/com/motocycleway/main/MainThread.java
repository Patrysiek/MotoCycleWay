package com.motocycleway.main;

import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.SurfaceHolder;

import com.motocycleway.R;
import com.motocycleway.activities.MainGameActivity;

public class MainThread extends Thread {
    public static final int MAX_FPS = 30;
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean running;
    private double averageFPS;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, GameView gameView){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
        gameView.setBackgroundResource(R.drawable.road);
        gameView.setZOrderOnTop(true);
        gameView.getHolder().setFormat(PixelFormat.TRANSLUCENT);

    }

    @Override
    public void run(){
        long startTime,timeMillis = 1000/MAX_FPS;
        long waitTime;
        int frameCount = 0;
        long totalTime = 0;
        long targetTime = 1000/MAX_FPS;
        while (running){
            startTime = System.nanoTime();
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                        this.gameView.update();

                    this.gameView.draw(canvas);
                }
            }catch (Exception e){
            }finally {
                if(canvas!=null){
                    try{
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }catch (Exception e){

                    }
                }
            }
            timeMillis = (System.nanoTime()-startTime)/1000000;
            waitTime = targetTime - timeMillis;
            try{
                if(waitTime>0)
                    this.sleep(waitTime);
            }catch (Exception e){
                e.printStackTrace();
            }
            totalTime+=System.nanoTime()-startTime;
            frameCount++;
            if(frameCount == MAX_FPS){
               averageFPS = 1000/((totalTime/frameCount)/1000000);
                Log.i("FPS",String.valueOf(averageFPS));
                frameCount = 0;
                totalTime = 0;

            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

package com.motocycleway.main;

import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.view.SurfaceHolder;

import com.motocycleway.R;

public class MainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean running;
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

        while (running){
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
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

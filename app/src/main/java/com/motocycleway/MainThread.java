package com.motocycleway;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private GameView gameView;
    final private SurfaceHolder surfaceHolder;
    private boolean running;
    private static Canvas canvas;
    public MainThread(SurfaceHolder surfaceHolderholder,GameView gameView ){
        super();
        this.gameView = gameView;
        this.surfaceHolder = surfaceHolderholder;
    }

    @Override
    public void run() {


        while (running){
            canvas = null;
            try{
                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameView.update();
                    this.gameView.draw(canvas);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally {

                if(canvas!=null){
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }


        }

    }
    public void setRunning(boolean running) {
        this.running = running;
    }

    public static Canvas getCanvas() {
        return canvas;
    }

    public static void setCanvas(Canvas canvas) {
        MainThread.canvas = canvas;
    }
}

package com.motocycleway;

import android.content.Context;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


class GameView extends SurfaceView implements SurfaceHolder.Callback {

    static private MainThread thread;
    static private Street street;
    static public Motobike motobike;
    static private ObstacleCar obstacleCar;
    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(),this);
        setFocusable(true);
    }



    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        motobike = new Motobike(BitmapFactory.decodeResource(getResources(),R.drawable.player_bike));
        street = new Street(BitmapFactory.decodeResource(getResources(),R.drawable.road));
        obstacleCar = new ObstacleCar(BitmapFactory.decodeResource(getResources(),R.drawable.obstacle_car));


            thread.setRunning(true);
            thread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;

        while (retry){
            try{
                thread.setRunning(false);
                thread.join();
            }catch (Exception e){
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update() {
        obstacleCar.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if(canvas!=null){
            street.draw(canvas);
            motobike.draw(canvas);
            obstacleCar.draw(canvas);

        }

    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                motobike.setX(event.getX());
                Log.i("blabla",String.valueOf(motobike.getX()));
                return true;
        }
        return super.onTouchEvent(event);
    }

}
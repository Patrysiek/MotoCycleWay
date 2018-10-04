package com.motocycleway.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


import com.motocycleway.R;

import com.motocycleway.activities.MenuActivity;
import com.motocycleway.entities.Motobike;
import com.motocycleway.entities.ObstacleCarManager;
import com.motocycleway.entities.Score;
import com.motocycleway.street.LinesManager;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    static private MainThread thread;
    static public Motobike motobike;
    static private ObstacleCarManager obstacleCarManager;
    private LinesManager linesManager;
    private Score score;
    private String loser = getResources().getString(R.string.loser);
    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(),this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        motobike = new Motobike(BitmapFactory.decodeResource(getResources(), R.drawable.player_bike));
        obstacleCarManager = new ObstacleCarManager(BitmapFactory.decodeResource(getResources(),R.drawable.obstacle_car));
        linesManager = new LinesManager(BitmapFactory.decodeResource(getResources(),R.drawable.short_line));
        score = new Score(Color.YELLOW);
        thread.setRunning(true);
        thread.start();


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        new GameOver(getHolder(),loser);
        getContext().getApplicationContext().startActivity(new Intent(getContext().getApplicationContext(),MenuActivity.class));

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
        if(!CrashDetector.motoCrashWithCar(obstacleCarManager.getMainLineList())) {
            linesManager.update();
            motobike.update();
            obstacleCarManager.update();

            score.update(motobike.getPositionPoint());
        }
        else{
            linesManager.update();
            motobike.update();
            obstacleCarManager.update();
            score.update(motobike.getPositionPoint());
            saveScore(score.getScore());


            surfaceDestroyed(getHolder());


        }

    }

    private void saveScore(int score) {
        ScoreManager.getScoreManager().saveScore(score);
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if(canvas!=null){
            linesManager.draw(canvas);
            motobike.draw(canvas);
            obstacleCarManager.draw(canvas);
            score.draw(canvas);
        }

    }


}

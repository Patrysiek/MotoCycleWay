package com.motocycleway;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;


import java.util.ArrayList;

public class Lines{
    private Bitmap bitmap;
    private ArrayList<Line> leftLines,rightLines;
    public static float yVelo = 3;
    public Lines(Bitmap bitmap){
        this.bitmap = bitmap;
        createLeftLines();
        createRightLines();
    }

    private void createRightLines() {
        rightLines = new ArrayList<>();
        for(int i = 0; i<7;i++){
            Line l = new Line(bitmap);
            l.setY(i*300);
            l.setX(Resources.getSystem().getDisplayMetrics().widthPixels*3/4+3);
            leftLines.add(l);
        }
    }

    private void createLeftLines() {
        leftLines = new ArrayList<>();
        for(int i = 0; i<7;i++){
            Line l = new Line(bitmap);
            l.setY(i*300);
            l.setX(Resources.getSystem().getDisplayMetrics().widthPixels/4-3);
            leftLines.add(l);
        }

    }

    public void draw(Canvas canvas){
        Canvas c = canvas;
        Thread t1 = new Thread(()-> {
            for(Line line : leftLines) {
                if(line.getY()>Resources.getSystem().getDisplayMetrics().heightPixels)
                    line.setY(0-line.getHeight());

                line.setY(line.getY()+yVelo);
                line.draw(c);
            }
        });
        Thread t2 = new Thread(()-> {
            for(Line line : rightLines) {
                if(line.getY()>Resources.getSystem().getDisplayMetrics().heightPixels)
                    line.setY(0-line.getHeight());

                line.setY(line.getY()+yVelo);
                line.draw(c);
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
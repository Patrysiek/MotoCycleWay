package com.motocycleway.entities;

import android.graphics.Canvas;
import android.graphics.Paint;


public class Score {
    private int score;
    private Paint paint;
       public Score(int color){
           paint = new Paint(color);
           paint.setTextSize(50);
           score = 0;
       }

    public  void update(int positionPoint){
        switch (positionPoint){
            case 0:
                score--;
                break;
            case 1:
                score++;
                break;
            case 2:
                score+=3;
                break;
            case -1:
                score+=5;
                break;
            case -2:
                score+=10;
            break;

            default:score +=0;
            break;

        }

    }
    public void draw(Canvas canvas){
        canvas.drawText(String.valueOf(score), 10,10,paint);
    }

    public int getScore() {
        return score;
    }
}

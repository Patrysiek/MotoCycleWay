package com.motocycleway.main;


import android.view.GestureDetector;
import android.view.MotionEvent;


public class SwipeBikeListener extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if( e1.getX()>e2.getX()){
            GameView.motobike.changeLeftPosition();
    }
        else if(e1.getX()<e2.getX()){
            GameView.motobike.changeRightPosition();
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }
}

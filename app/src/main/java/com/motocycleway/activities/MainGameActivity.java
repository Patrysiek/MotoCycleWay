package com.motocycleway.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.motocycleway.R;
import com.motocycleway.main.GameView;
import com.motocycleway.main.MyGestureListener;

public class MainGameActivity extends Activity {
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_game_layout);

        MyGestureListener myGestureListener = new MyGestureListener();
        mGestureDetector = new GestureDetector(this, myGestureListener);
        addLayout();
    }

    private void addLayout() {
        LinearLayout surface = findViewById(R.id.surface);
        GameView gameView = new GameView(this);
        surface.addView(gameView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);

        return super.onTouchEvent(event);
    }


}

package com.motocycleway.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.widget.LinearLayout;

import com.motocycleway.R;
import com.motocycleway.main.GameView;

public class MainGameActivity extends Activity {
    private int buttonId = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_game_layout);

        LinearLayout surface = findViewById(R.id.surface);
        surface.setWeightSum(10);
        GameView gameView = new GameView(this);

        surface.addView(gameView);
    }
}

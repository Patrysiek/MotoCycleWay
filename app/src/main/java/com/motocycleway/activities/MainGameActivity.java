package com.motocycleway.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.motocycleway.main.GameView;

public class MainGameActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
    }
}

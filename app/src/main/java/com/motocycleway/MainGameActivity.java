package com.motocycleway;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

class MainGameActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
    }
}

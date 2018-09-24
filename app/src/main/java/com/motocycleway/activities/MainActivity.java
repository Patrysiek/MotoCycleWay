package com.motocycleway.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.motocycleway.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMenuActivity();
    }

    private void setMenuActivity() {
        new Handler().postDelayed(()-> startActivity(new Intent(this,MenuActivity.class)),3000);
    }
}

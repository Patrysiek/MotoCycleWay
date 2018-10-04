package com.motocycleway.activities;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.motocycleway.R;



public class SettingsActivity extends Activity {

    final public static int HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;
    final public static int WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


    }


}
